package com.pettypal.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Notification;
import com.pettypal.domain.NotificationStatus;
import com.pettypal.domain.NotificationType;
import com.pettypal.domain.User;
import com.pettypal.repository.UserRepository;
import com.pettypal.service.FriendshipService;
import com.pettypal.service.NotificationService;
import com.pettypal.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FriendshipService friendshipService;
	
	
	@Autowired
	private NotificationService notificationService;

	public void requestFriend(long senderId,long recieverId) {
		Notification notification = new Notification();
		
		notification.setCreatedAt(new Date());
		notification.setUpdatedAt(new Date());
		notification.setCreatedBy(senderId);
		notification.setUpdatedBy(senderId);
		
		notification.setInitiator(getUser(senderId));
		notification.setReciever(getUser(recieverId));
		
		notification.setMessage("You have new friend request");
		
		notification.setStatus(NotificationStatus.OPEN);
		notification.setType(NotificationType.ADDFRIEND);
		
		notificationService.save(notification);
		
	}

	public List<User> findUsersByName(String name) {
		
		return userRepository.searchUserByName(name);
	}

	public List<User> getFriends(long userId) {
		
		return friendshipService.getFriendsList(userId);
	}

	public User acceptFriend(long userId, long notificationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(User user) {
		userRepository.save(user);
		
	}

	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}
	
	
	public User getUser(long id) {
		
		return userRepository.findOne(id);
	}

	public List<User> findFriendsByName(long userId, String name) {
		
		List<User> friends = getFriends(userId);
		
		friends.stream().filter(m -> m.getFirstName().contains(name) || m.getLastName().contains(name)).collect(Collectors.toList());
	
		
		return friends;
	}

}

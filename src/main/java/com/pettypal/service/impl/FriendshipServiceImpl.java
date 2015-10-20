package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;
import com.pettypal.repository.FriendshipRepository;
import com.pettypal.service.FriendshipService;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {
	
	@Autowired
	FriendshipRepository friendshipRepository;

	public List<Friendship> getFriendships(User user) {
		
		return friendshipRepository.findAllFriendsips(user.getId());

	}

	public Friendship save(Friendship friendship) {
		
		return friendshipRepository.save(friendship);
	}

	public Friendship getRelationship(User firstUser, User secondUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getFriendsList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

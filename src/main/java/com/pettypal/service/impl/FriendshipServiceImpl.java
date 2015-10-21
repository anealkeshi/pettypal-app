package com.pettypal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;
import com.pettypal.repository.FriendshipRepository;
import com.pettypal.service.FriendshipService;
import com.pettypal.service.UserService;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {
	
	@Autowired
	FriendshipRepository friendshipRepository;
	
	@Autowired
	UserService userService;

	public List<Friendship> getFriendships(long userid) {
		
		return friendshipRepository.findAllFriendsips(userid);

	}

	public Friendship save(Friendship friendship) {
		
		if(getRelationship(friendship.getFirstUser().getId(), friendship.getSecondUser().getId()) != null) return friendship;
		return friendshipRepository.save(friendship);
	}

	public Friendship getRelationship(long firstUser, long secondUser) {
		// TODO Auto-generated method stub
		return friendshipRepository.getRelationship(firstUser, secondUser);
	}

	public List<User> getFriendsList(long userid) {
		
		List<Friendship> list = getFriendships(userid);
		List<User> friendlist = new ArrayList<User>();
		
		for (Friendship f : list) {
			User user = null;
			if(f.getFirstUser().getId() == userid) 
			{
				 user = userService.getUser(f.getSecondUser().getId());
			}
			else user = userService.getUser(f.getFirstUser().getId());
			
			if(user!=null) friendlist.add(user);
		}
		
		return friendlist;
	}

}

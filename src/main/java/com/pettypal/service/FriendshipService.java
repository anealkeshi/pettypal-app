package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;

public interface FriendshipService {
	
	public List<Friendship> getFriendships(User user);
	
	public List<User> getFriendsList(User user);
	
	public Friendship save(Friendship friendship);
	
	public Friendship getRelationship(User firstUser, User secondUser);

}

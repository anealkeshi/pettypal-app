package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;

public interface FriendshipService {
	
	public List<Friendship> getFriendships(long id);
	
	public List<User> getFriendsList(long id);
	
	public Friendship save(Friendship friendship);
	
	public Friendship getRelationship(long firstUser, long secondUser);

}

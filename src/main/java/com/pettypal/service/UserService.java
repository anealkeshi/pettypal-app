package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.User;

public interface UserService {
	
	/**
	 * 
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(long id);
	
	/**
	 * Send a friend request
	 * @param userId
	 */
	public void requestFriend(long userId);
	
	/**
	 * Search users by name
	 * @param name Name of user
	 * @return A list of users matching the searched name
	 */
	public List<User> findUsersByName(String name);
	
	/**
	 * Get friends' list
	 * @return A list of the user's friends
	 */
	public List<User> getFriends(long userId);
	
	/**
	 * Accept a friend request
	 * @param userId
	 * @return The newly added friend user object.
	 */
	public User acceptFriend(long userId, long notificationId);
	

}

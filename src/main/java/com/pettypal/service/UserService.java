package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.User;
import com.pettypal.exception.NoSuchUserException;

public interface UserService {

	/**
	 * 
	 * @param user
	 */
	public User save(User user);

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
	 * Search users by name
	 * 
	 * @param name
	 *            Name of user
	 * @return A list of users matching the searched name
	 */
	public List<User> findUsersByName(String name);

	/**
	 * Search Users by firstName, lastName, username or email
	 * 
	 * @param nameOrUsernameOrEmail
	 * @return List of {@link User}
	 */
	List<User> searchUserByNameOrUsernameOrEmail(String nameOrUsernameOrEmail);

	/**
	 * Get {@link User} by username
	 * 
	 * @param username
	 * @return {@link User}
	 */
	User getUserByUsername(String username);

	/**
	 * 
	 * Get user by email
	 * 
	 * @param email
	 * @return
	 * @throws NoSuchUserException 
	 */
	User getUserByEmail(String email) throws NoSuchUserException;

}

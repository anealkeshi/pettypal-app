package com.pettypal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.User;
import com.pettypal.repository.UserRepository;
import com.pettypal.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void requestFriend(long userId) {
		// TODO Auto-generated method stub

	}

	public List<User> findUsersByName(String name) {

		return userRepository.searchUserByName(name);
	}

	public List<User> getFriends(long userId) {
		// TODO Auto-generated method stub
		return null;
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

	public List<User> searchUserByNameOrUsernameOrEmail(String nameOrUsernameOrEmail) {

		return userRepository.searchUserByNameOrUsernameOrEmail(nameOrUsernameOrEmail);
	}

	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

}

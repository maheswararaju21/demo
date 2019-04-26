package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.entity.User;

public interface UserService {

	public List<User> getAllUsers();

	User insertUser(User user);

	void update(User user, Long id);

	void deleteUser(Long userId);

	void deleteAllUsers(User user);
}

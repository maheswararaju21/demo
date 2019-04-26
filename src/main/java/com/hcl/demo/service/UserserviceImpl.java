package com.hcl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;

@Service
public class UserserviceImpl implements UserService {
	@Autowired
	UserRepository userrepo;

	@Override
	public List<User> getAllUsers() {

		return userrepo.findAll();
	}

	@Override
	public User insertUser(User user) {
		return userrepo.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		User userid = userrepo.getOne(userId);
		userrepo.delete(userid);

	}

	@Override
	public void update(User user, Long id) {
		userrepo.findById(id);
		user.setId(id);
		userrepo.save(user);
	}

	@Override
	public void deleteAllUsers(User user) {
		userrepo.deleteAll();
	}

}

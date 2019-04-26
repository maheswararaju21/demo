package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.User;
import com.hcl.demo.service.UserService;

@RestController
@RequestMapping(value = "/usercontroller")
public class UserController {
	@Autowired
	UserService userservice;

	@GetMapping(value = "/allusers")
	public List<User> getAllUsers() {
		return userservice.getAllUsers();
	}

	@PostMapping(value = "/insertusers")
	public ResponseEntity<User> insertUsers(@RequestBody User user) {
		userservice.insertUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateusers/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,
			@RequestBody User user) {
		userservice.update(user, id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteusers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> deleteUsers(@PathVariable Long id) {
		userservice.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteallusers")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllUsers(User user) {
		userservice.deleteAllUsers(user);

	}
}

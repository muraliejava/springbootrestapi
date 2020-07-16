package com.springboot.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.dao.UserDAO;
import com.springboot.rest.model.User;
import com.springboot.rest.model.Users;

/**
 * @author Murali
 *
 */
@RestController
@RequestMapping("/user-api")
public class UserController {
	@Autowired
	private UserDAO userDao;

	@RequestMapping(value = "/users", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Users getUsers() {
		return userDao.getAllUsers();
	}

	@RequestMapping(value = "/addUsers", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		Integer id = userDao.getAllUsers().getUserList().size() + 1;
		user.setUser_id(id);
		userDao.addUser(user);

		// Create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{user_id}")
				.buildAndExpand(user.getUser_id()).toUri();
		return ResponseEntity.created(location).build();

	}
}

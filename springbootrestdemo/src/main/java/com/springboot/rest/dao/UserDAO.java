package com.springboot.rest.dao;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.springboot.rest.model.User;
import com.springboot.rest.model.Users;

/**
 * @author Murali
 *
 */
@Repository
public class UserDAO {
	private static Users list = new Users();

	static {
		list.getUserList().add(new User(1, "User1", LocalDateTime.now(), LocalDateTime.now(),"Active"));
		list.getUserList().add(new User(2, "User2", LocalDateTime.now(), LocalDateTime.now(),"Inactive"));
		list.getUserList().add(new User(3, "User3", LocalDateTime.now(), LocalDateTime.now(),"Active"));
	}

	public Users getAllUsers() {
		return list;
	}

	public void addUser(User user) {
		list.getUserList().add(user);
	}
}

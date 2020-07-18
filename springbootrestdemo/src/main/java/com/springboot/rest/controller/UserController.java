package com.springboot.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.api.NotificationSender;
import com.springboot.rest.dao.UserDAO;
import com.springboot.rest.model.Users;
import com.springboot.rest.service.PayloadNotificationService;

/**
 * @author Murali
 *
 */
@RestController
@RequestMapping("/user-api")
public class UserController {
	@Autowired
	private UserDAO userDao;

	private final PayloadNotificationService payloadNotificationService;

	public UserController(PayloadNotificationService service) {
		this.payloadNotificationService = service;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Users getUsers() {
		return userDao.getAllUsers();
	}

	@RequestMapping(value = "/sendNotification", method = RequestMethod.POST)
	public void sendNotification(@Valid @RequestBody NotificationSender notificationSender) {
		payloadNotificationService.sendNotification(notificationSender);
	}
}

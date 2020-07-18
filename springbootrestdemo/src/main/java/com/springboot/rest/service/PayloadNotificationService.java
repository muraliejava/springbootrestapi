package com.springboot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.rest.api.NotificationSender;
import com.springboot.rest.api.PayloadMessageSender;

/**
 * @author Murali
 *
 */
@Service
public class PayloadNotificationService {
	
	private final PayloadMessageSender payloadMessageSender;
	
	@Autowired
	public PayloadNotificationService(@Qualifier("twilio") PayloadMessageSender messageSender) {
		payloadMessageSender = messageSender;
	}
	
	public void sendNotification(NotificationSender notificationSender) {
		payloadMessageSender.sendNotification(notificationSender);
	}
	

}

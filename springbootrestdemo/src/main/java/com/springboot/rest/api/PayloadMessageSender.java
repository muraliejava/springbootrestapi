package com.springboot.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

/**
 * @author Murali
 *
 */
@Service("twilio")
public class PayloadMessageSender implements PayloadNotificationSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayloadMessageSender.class);
	private final PayloadMessageConfiguration payloadAPI;

	@Autowired
	public PayloadMessageSender(PayloadMessageConfiguration payloadAPI) {
		this.payloadAPI = payloadAPI;
	}

	@Override
	public void sendNotification(NotificationSender notificationSender) {
		if (isPhoneNumberValid(notificationSender.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(notificationSender.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(payloadAPI.getTrialNumber());
			String message = notificationSender.getMessage();
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();
			LOGGER.info("Send notification success");
		} else {
			throw new IllegalArgumentException("phone number is not valid");
		}
	}

	private boolean isPhoneNumberValid(String phoneNumber) {
		return true;
	}
}

package com.springboot.rest.api;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationSender {

	@NotBlank
	private final String phoneNumber;
	@NotBlank
	private final String message;

	public NotificationSender(@JsonProperty("phoneNumber") String phoneNumber,
			@JsonProperty("message") String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "NotificationSender [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}

}

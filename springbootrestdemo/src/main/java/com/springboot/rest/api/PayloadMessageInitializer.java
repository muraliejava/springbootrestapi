package com.springboot.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

/**
 * @author Murali
 *
 */
@Configuration
public class PayloadMessageInitializer {

	private final static Logger LOGGER = LoggerFactory.getLogger(PayloadMessageInitializer.class);
	private final PayloadMessageConfiguration payloadMessageConfiguration;

	@Autowired
	public PayloadMessageInitializer(PayloadMessageConfiguration payloadMessageConfiguration) {
		this.payloadMessageConfiguration = payloadMessageConfiguration;
		Twilio.init(payloadMessageConfiguration.getAccountSid(), payloadMessageConfiguration.getAuthToken());
		LOGGER.info("Twilio Initialized...with account sid {}" + payloadMessageConfiguration.getAccountSid());
	}

}

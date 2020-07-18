package com.springboot.rest.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author Murali
 *
 */
@Service("pushy")
public class PayloadMessageSender {

	public static void sendSamplePush() {
		// Prepare list of target device tokens
		List<String> deviceTokens = new ArrayList<>();

		// Add your device tokens here
	    deviceTokens.add("cdd92f4ce847efa5c7f");
	    
		// Convert to String[] array
		String[] to = deviceTokens.toArray(new String[deviceTokens.size()]);

		// Set payload (any object, it will be serialized to JSON)
		Map<String, String> payload = new HashMap<>();

		// Add "message" parameter to payload
		payload.put("message", "Hello World!");

		// iOS notification fields
		Map<String, Object> notification = new HashMap<>();

		notification.put("badge", 1);
		notification.put("sound", "ping.aiff");
		notification.put("body", "Hello World");

		// Prepare the push request
		PayloadMessageInitializer.PushyPushRequest push = new PayloadMessageInitializer.PushyPushRequest(payload, to, notification);

		try {
			// Try sending the push notification
			PayloadMessageInitializer.sendPush(push);
		}
		catch (Exception exc) {
			// Error, print to console
			System.out.println(exc.toString());
		}
	}
}

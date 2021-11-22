/**
 * 	Testing the MessageResponse getters and setters
 */
package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.myrev.payload.MessageResponse;

/**
 * @author Dipanjali Ghosh
 *
 */
public class MessageResponseTest {
	@Test
	void messageResponseConstructorTest() {
		MessageResponse testMessageResponse = new MessageResponse();
		assertNotNull(testMessageResponse, "Constructor failed");
	}

	@Test
	void messageGetterTest() {
		MessageResponse testMessageResponse = new MessageResponse();
		assertNull(testMessageResponse.getMessage(), "testMessageResponse.message is not null");
	}

	@Test
	void messageSetterTest() {
		String testMessage = "Test message here. Hello, World!";
		MessageResponse testMessageResponse = new MessageResponse();
		testMessageResponse.setMessage(testMessage);
		assertEquals(0, testMessageResponse.getMessage().compareTo(testMessage));
	}

	@Test
	void messageResponseConstructorWithParamTest() {
		String testMessage = "Test message here. Hello, World!";
		MessageResponse testMessageResponse = new MessageResponse(testMessage);
		assertEquals(0, testMessageResponse.getMessage().compareTo(testMessage));
	}
}

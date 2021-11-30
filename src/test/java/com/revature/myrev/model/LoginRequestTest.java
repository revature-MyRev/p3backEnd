/**
 * 		Testing the LoginRequest Getters and Setters
 */
package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.myrev.payload.LoginRequest;

/**
 * @author Dipanjali Ghosh
 *
 */
public class LoginRequestTest {
	@Test
	void loginRequestConstructorTest() {
		LoginRequest testLoginRequest = new LoginRequest();
		assertNotNull(testLoginRequest, "Constructor failed");
	}

	@Test
	void usernameGetterTest() {
		LoginRequest testLoginRequest = new LoginRequest();
		assertNull(testLoginRequest.getUsername(), "testLoginRequest.username is not null");
	}

	@Test
	void usernameSetterTest() {
		String testUsername = "tester123";
		LoginRequest testLoginRequest = new LoginRequest();
		testLoginRequest.setUsername(testUsername);
		assertEquals(0, testLoginRequest.getUsername().compareTo(testUsername));
	}

	@Test
	void passwordGetterTest() {
		LoginRequest testLoginRequest = new LoginRequest();
		assertNull(testLoginRequest.getPassword(), "testLoginRequest.password is not null");
	}

	@Test
	void passwordSetterTest() {
		String testPassword = "testPass";
		LoginRequest testLoginRequest = new LoginRequest();
		testLoginRequest.setPassword(testPassword);
		assertEquals(0, testLoginRequest.getPassword().compareTo(testPassword));
	}

	@Test
	void loginRequestConstructorWithParamsTest() {
		String testUsername = "tester123";
		String testPassword = "testPass";
		LoginRequest testLoginRequest = new LoginRequest(testUsername, testPassword);
		assertEquals(0, testLoginRequest.getUsername().compareTo(testUsername));
		assertEquals(0, testLoginRequest.getPassword().compareTo(testPassword));
	}
}

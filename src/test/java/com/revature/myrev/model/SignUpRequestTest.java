/**
 * 		Testing the SignUpRequest Getters and Setters
 */
package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.myrev.payload.SignUpRequest;

import java.util.Set;

/**
 * @author Dipanjali Ghosh
 *
 */
public class SignUpRequestTest {
	@Test
	void signUpRequestConstructorTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNotNull(testSignUpRequest, "Constructor failed");
	}

	@Test
	void usernameGetterTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNull(testSignUpRequest.getUsername(), "testSignUpRequest.username is not null");
	}

	@Test
	void usernameSetterTest() {
		String testUsername = "tester123";
		SignUpRequest testSignUpRequest = new SignUpRequest();
		testSignUpRequest.setUsername(testUsername);
		assertEquals(0, testSignUpRequest.getUsername().compareTo(testUsername));
	}

	@Test
	void firstnameGetterTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNull(testSignUpRequest.getFirstname(), "testSignUpRequest.firstname is not null");
	}

	@Test
	void firstnameSetterTest() {
		String testFirstname = "Test";
		SignUpRequest testSignUpRequest = new SignUpRequest();
		testSignUpRequest.setFirstname(testFirstname);
		assertEquals(0, testSignUpRequest.getFirstname().compareTo(testFirstname));
	}

	@Test
	void lastnameGetterTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNull(testSignUpRequest.getLastname(), "testSignUpRequest.lastname is not null");
	}

	@Test
	void lastnameSetterTest() {
		String testLastname = "Token";
		SignUpRequest testSignUpRequest = new SignUpRequest();
		testSignUpRequest.setLastname(testLastname);
		assertEquals(0, testSignUpRequest.getLastname().compareTo(testLastname));
	}

	@Test
	void emailGetterTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNull(testSignUpRequest.getEmail(), "testSignUpRequest.email is not null");
	}

	@Test
	void emailSetterTest() {
		String testEmail = "test@gmail.com";
		SignUpRequest testSignUpRequest = new SignUpRequest();
		testSignUpRequest.setEmail(testEmail);
		assertEquals(0, testSignUpRequest.getEmail().compareTo(testEmail));
	}

	@Test
	void passwordGetterTest() {
		SignUpRequest testSignUpRequest = new SignUpRequest();
		assertNull(testSignUpRequest.getPassword(), "testSignUpRequest.password is not null");
	}

	@Test
	void passwordSetterTest() {
		String testPassword = "testPassword";
		SignUpRequest testSignUpRequest = new SignUpRequest();
		testSignUpRequest.setPassword(testPassword);
		assertEquals(0, testSignUpRequest.getPassword().compareTo(testPassword));
	}

	@Test
	void signUpRequestConstructorWithParamsTest() {
		String testUsername = "tester123";
		String testFirstname = "Test";
		String testLastname = "Token";
		String testEmail = "test@gmail.com";
		String testPassword = "testPassword";
		SignUpRequest testSignUpRequest = new SignUpRequest(testUsername, testFirstname, testLastname, testEmail,
				testPassword);
		assertEquals(0, testSignUpRequest.getUsername().compareTo(testUsername));
		assertEquals(0, testSignUpRequest.getFirstname().compareTo(testFirstname));
		assertEquals(0, testSignUpRequest.getLastname().compareTo(testLastname));
		assertEquals(0, testSignUpRequest.getEmail().compareTo(testEmail));
		assertEquals(0, testSignUpRequest.getPassword().compareTo(testPassword));
	}
}

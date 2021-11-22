/**
 * 		Testing the JwtResponse Getters and Setters
 */
package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.myrev.payload.JwtResponse;

/**
 * @author Dipanjali Ghosh
 *
 */
public class JwtResponseTest {
	@Test
	void tokenGetterTest() {
		String testToken = "test.Token.Ttoeksetn";
		JwtResponse testJwtResponse = new JwtResponse(testToken, 0, null, null, null);
		testJwtResponse.setAccessToken(testToken);
		assertNotNull(testJwtResponse.getAccessToken(), "testJwtResponse is null");
	}

	@Test
	void tokenSetterTest() {
		String testToken = "test.Token.Ttoeksetn";
		JwtResponse testJwtResponse = new JwtResponse(testToken, 0, null, null, null);
		testJwtResponse.setAccessToken(testToken);
		assertEquals(0, testJwtResponse.getAccessToken().compareTo(testToken));
	}

	@Test
	void typeGetterTest() {
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		assertNotNull(testJwtResponse.getTokenType(), "testJwtResponse.type is null");
		assertEquals(0, testJwtResponse.getTokenType().compareTo("Bearer")); // Bearer is the default type
	}

	@Test
	void typeSetterTest() {
		String testType = "testType";
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		testJwtResponse.setTokenType(testType);
		assertEquals(0, testJwtResponse.getTokenType().compareTo(testType));
	}

	@Test
	void idGetterTest() {
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		assertEquals(0, testJwtResponse.getId());
	}

	@Test
	void idSetterTest() {
		int testId = 1;
		JwtResponse testJwtResponse = new JwtResponse(null, testId, null, null, null);
		assertEquals(testId, testJwtResponse.getId());
	}

	@Test
	void usernameGetterTest() {
		String testUsername = "testUsername";
		JwtResponse testJwtResponse = new JwtResponse(null, 0, testUsername, null, null);
		assertNotNull(testJwtResponse.getUsername(), "testJwtResponse.username is null");
		assertEquals(0, testJwtResponse.getUsername().compareTo(testUsername));
	}

	@Test
	void usernameSetterTest() {
		String testUsername = "testUsername";
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		testJwtResponse.setUsername(testUsername);
		assertEquals(0, testJwtResponse.getUsername().compareTo(testUsername));
	}

	@Test
	void emailGetterTest() {
		String testEmail = "test@gmail.com";
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, testEmail, null);
		assertNotNull(testJwtResponse.getEmail(), "testJwtResponse.email is null");
		assertEquals(0, testJwtResponse.getEmail().compareTo(testEmail));
	}

	@Test
	void emailSetterTest() {
		String testEmail = "test@gmail.com";
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		testJwtResponse.setEmail(testEmail);
		assertEquals(0, testJwtResponse.getEmail().compareTo(testEmail));
	}

	@Test
	void rolesGetterTest() {
		List<String> testRoles = new ArrayList<String>();
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, testRoles);
		assertNotNull(testJwtResponse.getRoles(), "testJwtResponse.roles is null");
		assertEquals(testRoles, testJwtResponse.getRoles());
	}

	@Test
	void rolesSetterTest() {
		List<String> testRoles = new ArrayList<String>();
		testRoles.add("ROLE_USER");
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		testJwtResponse.setRoles(testRoles);
		assertEquals(testRoles, testJwtResponse.getRoles());
	}

	/**
	 * Testing what the getter and setter for roles again, but this time the List
	 * has 2 roles instead of 1.
	 */
	@Test
	void doubleRolesGetterTest() {
		List<String> testRoles = new ArrayList<String>();
		testRoles.add("ROLE_USER");
		testRoles.add("ROLE_ADMIN");
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, testRoles);
		assertNotNull(testJwtResponse.getRoles(), "testJwtResponse.roles is null");
		assertEquals(testRoles, testJwtResponse.getRoles());
	}

	@Test
	void doubleRolesSetterTest() {
		List<String> testRoles = new ArrayList<String>();
		testRoles.add("ROLE_USER");
		testRoles.add("ROLES_ADMIN");
		JwtResponse testJwtResponse = new JwtResponse(null, 0, null, null, null);
		testJwtResponse.setRoles(testRoles);
		assertEquals(testRoles, testJwtResponse.getRoles());
	}

	@Test
	void jwtResponseConstructorWithParamsTest() {
		String testToken = "test.Token.Ttoeksetn";
		String testType = "Bearer";
		int testId = 1;
		String testUsername = "tester123";
		String testEmail = "test@gmail.com";
		List<String> testRoles = new ArrayList<String>();
		testRoles.add("ROLE_USER");
		JwtResponse testJwtResponse = new JwtResponse(testToken, testId, testUsername, testEmail, testRoles);

		assertEquals(0, testJwtResponse.getAccessToken().compareTo(testToken));
		assertEquals(0, testJwtResponse.getTokenType().compareTo(testType));
		assertEquals(testId, testJwtResponse.getId());
		assertEquals(0, testJwtResponse.getUsername().compareTo(testUsername));
		assertEquals(0, testJwtResponse.getEmail().compareTo(testEmail));
		assertEquals(testRoles, testJwtResponse.getRoles());
	}
}

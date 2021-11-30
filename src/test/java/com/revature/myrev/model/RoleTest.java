/**
 * 		Testing the Role Getters and Setters
 */
package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Dipanjali Ghosh
 *
 */
public class RoleTest {

	@Test
	void roleConstructorTest() {
		Role testRole = new Role();
		assertNotNull(testRole, "Constructor failed");
	}

	@Test
	void roleIdGetterTest() {
		Role testRole = new Role();
		assertEquals(0, testRole.getRoleId());
	}

	@Test
	void roleIdSetterTest() {
		int test = 1;
		Role testRole = new Role();
		testRole.setRoleId(test);
		assertEquals(test, testRole.getRoleId());
	}

	@Test
	void roleNameGetterTest() {
		Role testRole = new Role();
		assertNull(testRole.getName(), "testRole.name not null");
	}

	@Test
	void roleNameSetterTest() {
		ERole test = ERole.ROLE_USER;
		Role testRole = new Role();
		testRole.setName(test);
		assertEquals(0, testRole.getName().compareTo(test));
	}

	@Test
	void roleConstructorWithParamsTest() {
		int testId = 1;
		ERole testName = ERole.ROLE_USER;
		Role testRole = new Role(testId, testName);
		assertEquals(testId, testRole.getRoleId());
		assertEquals(0, testRole.getName().compareTo(testName));
	}
}

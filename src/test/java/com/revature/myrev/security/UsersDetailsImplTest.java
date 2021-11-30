/**
 * 		Testing the Constructors, Getters, and setters of
 * 			UsersDetailsImpl
 */
package com.revature.myrev.security;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import com.revature.myrev.model.ERole;
import com.revature.myrev.model.Role;
import com.revature.myrev.model.Users;

/**
 * @author Dipanjali Ghosh
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class UsersDetailsImplTest {
	private static Users testUser;
	private static Set<Role> testRoles;
	private static UsersDetailsImpl testControl;

	@BeforeAll
	void initializeValues() {
		Role testRole = new Role(1, ERole.ROLE_USER);
		testUser = new Users(1, 26, "testUsername", "testPassword", "Non-binary", "testPhoto.jpg",
				"first.last@revature.net", "First", "Last", "Middle", "testJobTitle");
		testRoles = new HashSet<Role>();
		testRoles.add(testRole);
		testControl = UsersDetailsImpl.build(testUser);
	}

	@Test
	@Order(1)
	void usersDetailsImplBuildTest() {
		assertNotNull(testControl, "Build method failed");
	}

	@Test
	@Order(2)
	void getAuthorities() {
		assertNotNull(testControl.getAuthorities(), "testControl.authorities is null");
	}

	@Test
	@Order(3)
	void usersDetailsImplConstructorAllParamsTest() {
		UsersDetailsImpl testUsersDetailsImpl = new UsersDetailsImpl(testUser.getUserId(), testUser.getUserName(),
				testUser.getEmail(), testUser.getPassword(), testControl.getAuthorities());
		assertNotNull(testUsersDetailsImpl, "Constructor with all Params failed");
	}

	@Test
	@Order(4)
	void usersDetailsImplIdGetterTest() {
		assertEquals(testUser.getUserId(), testControl.getId()); // as the UsersDetailsImpl id should be the user id
	}

	@Test
	@Order(5)
	void usersDetailsImplEmailGetterTest() {
		assertEquals(testUser.getEmail(), testControl.getEmail());
	}

	@Test
	@Order(6)
	void usersDetailsImplPasswordGetterTest() {
		assertEquals(testUser.getPassword(), testControl.getPassword());
	}

	@Test
	@Order(7)
	void usersDetailsImplUsernameGetterTest() {
		assertEquals(testUser.getUserName(), testControl.getUsername());
	}

	@Test
	@Order(8)
	void usersDetailsImplIsAccountNonExpiredGetterTest() {
		assertTrue(testControl.isAccountNonExpired(), "testControl.account is Expired");
		assertFalse(!testControl.isAccountNonExpired(), "!testControl.account is not Expired");
	}

	@Test
	@Order(9)
	void usersDetailsImplIsAccountNonLockedGetterTest() {
		assertTrue(testControl.isAccountNonLocked(), "testControl.account is Locked");
		assertFalse(!testControl.isAccountNonLocked(), "!testControl.account is not Locked");
	}

	@Test
	@Order(10)
	void usersDetailsImplIsCredentialsNonExpiredGetterTest() {
		assertTrue(testControl.isCredentialsNonExpired(), "testControl.credentials is Expired");
		assertFalse(!testControl.isCredentialsNonExpired(), "!testControl.credentials is not Expired");
	}

	@Test
	@Order(11)
	void usersDetailsImplIsEnabledGetterTest() {
		assertTrue(testControl.isEnabled(), "testControl is not Enabled");
		assertFalse(!testControl.isEnabled(), "!testControl is Enabled");
	}

	@Test
	@Order(12)
	void usersDetailsImplEqualsTest() {
		assertTrue(testControl.equals(testControl), "testControl.equals(testControl) failed");
		assertFalse(testControl.equals(null), "testControl.equals(null) came out true");
		UsersDetailsImpl testUsersDetailsImpl = new UsersDetailsImpl(testUser.getUserId(), testUser.getUserName(),
				testUser.getEmail(), testUser.getPassword(), testControl.getAuthorities());
		assertTrue(testControl.equals(testUsersDetailsImpl), "testControl.equals(testUsersDetailsImpl) failed");
	}
}

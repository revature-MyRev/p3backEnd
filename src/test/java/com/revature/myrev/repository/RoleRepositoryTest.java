package com.revature.myrev.repository;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.ERole;
import com.revature.myrev.model.Role;

/**
 * @author Dipanjali Ghosh
 *
 */
@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
@Transactional
class RoleRepositoryTest {
	// Not mocking anything here.
	// Be sure to delete any additions made to table at the end of each test
	/** RoleRepository for testing */
	@Autowired
	private RoleRepository repository;

	/**
	 * Tests for a successful addition to the Role table
	 */
	@Test
	@Order(1)
	void testCreateRoles() {

		Role testRole = new Role(1, ERole.ROLE_USER);

		Role result = repository.save(testRole);

		Assertions.assertNotEquals(0, result.getRoleId());
		Assertions.assertEquals(testRole.getRoleId(), result.getRoleId());
	}

	/**
	 * Tests findByRoleName Both positive and negative tests
	 */
	@Test
	@Order(2)
	void testFindByRolename() {
		// Test on empty table
		Optional<Role> result = repository.findByName(null);

		Assertions.assertNotNull(result, "result is Null");
		Assertions.assertTrue(!result.isPresent(), "value present");

		// Test on nonempty table with invalid role name
		Role testRole = new Role(1, ERole.ROLE_USER);
		repository.save(testRole);

		result = repository.findByName(ERole.ROLE_ADMIN);

		Assertions.assertNotNull(result, "result is Null");
		Assertions.assertTrue(!result.isPresent(), "value present");

		// Test on nonempty table with valid user name
		result = repository.findByName(ERole.ROLE_USER);

		Assertions.assertNotNull(result);
		Assertions.assertEquals(ERole.ROLE_USER, result.get().getName());
	}

}

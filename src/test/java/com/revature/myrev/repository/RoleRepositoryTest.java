package com.revature.myrev.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.ERole;
import com.revature.myrev.model.Role;
import com.revature.myrev.model.Role;

/**
 * @author Dipanjali Ghosh
 *
 */
@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class RoleRepositoryTest {
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
	public void testCreateRoles() {

		Role testRole = new Role(1, ERole.ROLE_USER);

		Role result = repository.save(testRole);

		Assertions.assertNotEquals(0, result.getRoleId());
		Assertions.assertEquals(testRole.toString(), result.toString());
	}

	/**
	 * Tests findByUserName
	 * Both positive and negative tests
	 */
	@Test
	@Order(2)
	public void testFindByRolename() {
//		// Test on empty table
//		//Role result = repository.findByName();
//		
//		Assertions.assertNull(result);
//		
//		
//		// Test on nonempty table with invalid user name
//		Role testRole = new Role(1, ERole.ROLE_USER);
//		repository.save(testRole);
//		
//		result = repository.findById();
//		
//		Assertions.assertNull(result);
//		
//		
//        // Test on nonempty table with valid user name
//		result = repository.findByUserName(testRole.getUserName());
//
//		Assertions.assertNotNull(result);
//		Assertions.assertEquals(20, result.getAge());
	}

}

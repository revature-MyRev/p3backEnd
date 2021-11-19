package com.revature.myrev.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Users;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class UsersRepositoryTest {

	// Not mocking anything here.
	// Be sure to delete any additions made to table at the end of each test
	/** UserRepository for testing */
	@Autowired
	private UsersRepository repository;

	/**
	 * Tests for a successful addition to the user table 
	 */
	@Test
	@Order(1)
	public void testCreateUsers() {

		Users testUser = new Users(0, 20, "Tester1234", "test123", "Female", "null", "test@revature.com", "Test",
				"Testing", "JUnit", "Tester");

		Users result = repository.save(testUser);

		Assertions.assertNotEquals(0, result.getUserId());
		Assertions.assertEquals(testUser.toString(), result.toString());
	}

	/**
	 * Tests findByUserName
	 * Both positive and negative tests
	 */
	@Test
	@Order(2)
	public void testFindByUsername() {
		// Test on empty table
		Users result = repository.findByUserName("user1");
		
		Assertions.assertNull(result);
		
		
		// Test on nonempty table with invalid user name
		Users testUser = new Users(0, 20, "Tester1234", "test123", "Female", "null", "test@revature.com", "Test",
				"Testing", "JUnit", "Tester");
		repository.save(testUser);
		
		result = repository.findByUserName("user1");
		
		Assertions.assertNull(result);
		
		
        // Test on nonempty table with valid user name
		result = repository.findByUserName(testUser.getUserName());

		Assertions.assertNotNull(result);
		Assertions.assertEquals(20, result.getAge());
	}

}

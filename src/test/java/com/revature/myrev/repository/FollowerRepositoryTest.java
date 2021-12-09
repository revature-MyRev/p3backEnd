package com.revature.myrev.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Follower;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(true)
class FollowerRepositoryTest {
	
	// Not mocking anything here. 
	// Be sure to delete any additions made to table at the end of each test
	/** FollowerRepository for testing */
	@Autowired
	private FollowerRepository repository;

	@PersistenceContext
	EntityManager entityManager;
	
	@Test
	@Order(1)
	@Disabled
	public void init() {
		Follower f1 = new Follower(3,1,2);
		Follower f2 = new Follower(4,2,1);
		entityManager
	    .createNativeQuery("ALTER TABLE follower AUTO_INCREMENT = 1")
	    .executeUpdate(); 
		repository.save(f1);
		repository.save(f2);
	}
	
	@Test
	@Order(2)
	@Disabled
	public void testFindByFollowedIdAndFollowerId() {
		String actual = repository.findByFollowedIdAndFollowerId(1, 2).toString();
		String expected = new Follower(4,2,1).toString();
		assertEquals(actual, expected, "Expected: " + expected + "Actual: " + actual);
	}
	
	@Test
	@Order(3)
	@Disabled
	public void testFindByFollowedIdAndFollowerIdNullExpected() {
		String actual = repository.findByFollowedIdAndFollowerId(6, 9).toString();
		String expected = null;
		assertEquals(actual, expected, "Expected: " + expected + "Actual: " + actual);
	}

	@Test
	@Order(4)
	public void removeEntitiesFromDB() {
		repository.delete(new Follower(3,1,2));
		repository.delete(new Follower(4,2,1));
	}
}

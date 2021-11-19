package com.revature.myrev.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
@DataJpaTest
class FollowerRepositoryTest {
	
	// Not mocking anything here. 
	// Be sure to delete any additions made to table at the end of each test
	/** FollowerRepository for testing */
	@Autowired
	private FollowerRepository repository;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

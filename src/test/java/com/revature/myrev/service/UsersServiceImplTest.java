package com.revature.myrev.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.repository.UserRepository;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
class UsersServiceImplTest {

	/** Mock UserRespository for Mockito testing */
	@Mock
	//private UsersRepository repository;
	private UserRepository repository;
	/** UserService for JUnit testing */
	@Autowired
	@InjectMocks
	//private UsersService service;
	UserService service;
	/** Used for the initialization & closing of mocked fields */
    private AutoCloseable closeable;
	
	@Before
	public void setUp () {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@After
	public void releaseMocks () throws Exception {
		closeable.close();
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}


}

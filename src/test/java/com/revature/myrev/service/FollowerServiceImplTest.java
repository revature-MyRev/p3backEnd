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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.repository.FollowerRepository;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
class FollowerServiceImplTest {
	
	/** Mock FollowerRespository for Mockito testing */
	@Mock
	private FollowerRepository repository;
	/** FollowerService for JUnit testing */
	@Autowired
	@InjectMocks
	FollowerService service;
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

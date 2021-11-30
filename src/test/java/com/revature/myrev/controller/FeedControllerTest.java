package com.revature.myrev.controller;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.service.FollowerServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Rollback(false)
class FeedControllerTest {

	// You may find these useful for your tests
	/** Mock ThreadService for Mockito tests */
	@Mock
	private FollowerServiceImpl service;
	/** Mocked servlet environment for Mockito tests */
	@Autowired
	private MockMvc mvc;
	/** ThreadController for any sort of JUnit test */
	@Autowired
	@InjectMocks
	private FeedController controller;
	/** Used for the initialization & closing of mocked fields */
	private AutoCloseable closeable;
	/** Useful for reading & writing JSON to & from POJOS */
	private ObjectMapper mapper;

	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		mapper = new ObjectMapper();
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

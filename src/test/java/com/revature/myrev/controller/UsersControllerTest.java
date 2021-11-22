//package com.revature.myrev.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.myrev.MyRevApplication;
//
//// change import once everyone has all cases of user switched to users
////import com.revature.myrev.service.UsersServiceImpl;
//
//import com.revature.myrev.service.UsersServiceImpl;
//
//
//@SpringBootTest
//@ContextConfiguration(classes = MyRevApplication.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@AutoConfigureMockMvc
//@Rollback(false)
//class UsersControllerTest {
//	
//	// You may find these useful for your tests
//	/** Mock UsersService for Mockito tests */
//	@Mock
//	//private UsersServiceImpl service;
//
//	private UserServiceImpl service;
//
//	/** Mocked servlet environment for Mockito tests */
//	@Autowired
//	private MockMvc mvc;
//	/** UsersController for any sort of JUnit test */
//	@Autowired
//	@InjectMocks
//	//private UsersController controller;
//
//	private UserController controller;
//
//	
//	/** Used for the initialization & closing of mocked fields */
//    private AutoCloseable closeable;
//    /** Useful for reading & writing JSON to & from POJOS */
//    private ObjectMapper mapper;
//
//	
//	@Before
//	public void setUp () {
//		closeable = MockitoAnnotations.openMocks(this);
//		mvc = MockMvcBuilders.standaloneSetup(controller).build();
//		mapper = new ObjectMapper();
//	}
//	
//	@After
//	public void releaseMocks () throws Exception {
//		closeable.close();
//	}
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}

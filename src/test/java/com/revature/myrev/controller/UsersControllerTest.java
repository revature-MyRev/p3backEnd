package com.revature.myrev.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Users;
// change import once everyone has all cases of user switched to users
//import com.revature.myrev.service.UsersServiceImpl;
import com.revature.myrev.service.UsersServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Rollback(false)
class UsersControllerTest {
	
	// You may find these useful for your tests
	/** Mock UsersService for Mockito tests */
	@Mock
	private UsersServiceImpl service;
	/** Mocked servlet environment for Mockito tests */
	@Autowired
	private MockMvc mvc;
	/** UsersController for any sort of JUnit test */
	@Autowired
	@InjectMocks
	private UsersController controller;
	/** Used for the initialization & closing of mocked fields */
    private AutoCloseable closeable;
    /** Useful for reading & writing JSON to & from POJOS */
    private ObjectMapper mapper;
    private JacksonTester<Users> json; 
    private Users u1 = new Users(100, 37, "test123","password", "male", "photo", "email@gmail.com", "Fname", "Lname", "Mname", "jobtitle");
    private List<Users> mockUsers = new ArrayList<>();

	
	@Before
	public void setUp () {
		closeable = MockitoAnnotations.openMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		mapper = new ObjectMapper();
	}
	
	@After
	public void releaseMocks () throws Exception {
		closeable.close();
	}

	@Test
	public void testFindByUsername () {
		Users usre1 = new Users(100, 37, "test123","password", "male", "photo", "email@gmail.com", "Fname", "Lname", "Mname", "jobtitle");
		//test for exception on empty table
		
		//test for exception on invalid username
		
		//test for returned user on valid username
		Users user2 = controller.findByUserName("test123");
		
	}

}

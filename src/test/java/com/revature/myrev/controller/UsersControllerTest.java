package com.revature.myrev.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.exception.ObjectNotFoundException;
import com.revature.myrev.model.Users;
import com.revature.myrev.service.UsersService;
import com.revature.myrev.controller.UserController;
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
	@MockBean
	private UsersServiceImpl service;
	/** Mocked servlet environment for Mockito tests */
	@Autowired
	private MockMvc mvc;
	/** UsersController for any sort of JUnit test */
	@Autowired
	@InjectMocks
	private UserController controller;
	/** Used for the initialization & closing of mocked fields */
	private AutoCloseable closeable;
	/** Useful for reading & writing JSON to & from POJOS */
	private ObjectMapper mapper = new ObjectMapper();
	private JacksonTester<Users> json;


	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	/**
	 * Test for returned user on valid user name
	 * 
	 * @throws Exception if user is not found.
	 */
	@Test
	public void testFindByUsername() throws Exception {
		Users user1 = new Users(100, 37, "test123", "password", "male", "photo", "email@gmail.com", "Fname", "Lname",
				"Mname", "jobtitle");

		when(service.findByUserName(any())).thenReturn(user1);

		MockHttpServletResponse response = mvc
				.perform(get("/users/findByUserName/test123").accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();

		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
		verify(service, times(1)).findByUserName("test123");
	}

	/**
	 *  Test for NOT_FOUND HttpStatus when passed an invalid user name or the table is empty
	 *  
	 *  @throws Exception when a user is not found
	 */
	@Test
	public void testUserNotFound() throws Exception {

		when(service.findByUserName(any())).thenThrow(ObjectNotFoundException.class);

		MockHttpServletResponse response = mvc
				.perform(get("/users/findByUserName/test123").accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse();
		
		Assert.assertTrue(response.getStatus() == HttpStatus.NOT_FOUND.value());
        verify(service, times(1)).findByUserName("test123");
	}
	
 // Adding new user
	@Test
	public void addUser() throws Exception {
		Users user1 = new Users(200, 40, "test333", "password", "male", "photo", "email@gmail.com", "Fname", "Lname",
				"Mname", "jobtitle");

		when(service.save(any())).thenReturn(user1);

		String json = mapper.writeValueAsString(user1);
		MockHttpServletResponse response = mvc
				.perform(post("/users/addUser").contentType(MediaType.APPLICATION_JSON).content(json))
				.andReturn().getResponse();

		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());

	}
//	//  Test adding new user without userName
//		@Test
//		public void addInValidUser() throws Exception {
//			Users user = new Users();
//			
//
//			//when(service.save(any())).thenReturn(user1);
//
//			MockHttpServletResponse response = mvc
//					.perform(post("/users/addUser").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//					.andReturn().getResponse();
//
//			System.out.println(response.getContentType());
//			System.out.println(response.getContentAsString());
//			Assert.assertTrue(response.getStatus() == HttpStatus.BAD_REQUEST.value());
//
//		}
}

package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.controller.UserController;
import com.revature.myrev.model.User;
import com.revature.myrev.service.UserServiceImpl;

public class TestUserController {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserServiceImpl userService;
	
	User user;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		user = new User();
		
		user.setAge(38);
		user.setEmail("test@aol.com");
		user.setFirstName("John");
		user.setLastName("Smith");
		user.setGender("Male");
		user.setJobTitle("Software Engineer");
	}
	
	@Test
	final void testGetUser() {
		when(userService.findById(anyInt())).thenReturn(user);
		assertNotNull(user);
		assertEquals("Smith", user.getLastName());
	}
}

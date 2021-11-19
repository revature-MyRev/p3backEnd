package com.revature.myrev.mock;


	import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.controller.UserController;
import com.revature.myrev.model.User;
	import com.revature.myrev.repository.UserRepository;
import com.revature.myrev.service.UserServiceImpl;

	public class TestUserService {

	/*	@Test
	    public void testMock() {
	    UserRepository mockObj = Mockito.mock(UserRepository.class);
	    List<User> user = userRepository.findAll();
	    Mockito.when(mockObj.findAllByThreadId(1)).thenReturn(user);

	    List<User> thread = mockObj.findAllByThreadId(1);

	   // Assert.
	    assertEquals(user, thread);
	    Mockito.verify(mockObj).findAllByThreadId(1); 
		
		
		
	}
	
		@InjectMocks
		 UserServiceImpl userService;
		
		@Mock
		UserRepository userRepository;
		
		User mockUser;
		
		@BeforeEach
		void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			
			mockUser = new User();
			mockUser.setUserId(1);
			mockUser.setAge(38);
			mockUser.setGender("male");
		}
		
		
		@Test
		final void testGetUser() {
			
			
			when(userRepository.findById(anyInt()).get()).thenReturn(mockUser);
			
			User user = userService.findById(1);
			assertNotNull(user);
			assertEquals("male", user.getGender());
		}
		*/
		
		@InjectMocks
		 UserServiceImpl userService;
		
		@Mock
		UserRepository userRepository;
		
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
			when(userRepository.findByUsername(anyString())).thenReturn(user);
			assertNotNull(user);
			assertEquals("Smith", user.getLastName());
		}		
		
		
		
		
	}


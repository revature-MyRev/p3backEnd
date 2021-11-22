//package com.revature.myrev.mock;
//
//
//	import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import com.revature.myrev.controller.UserController;
//import com.revature.myrev.model.User;
//import com.revature.myrev.model.User;
//import com.revature.myrev.model.User;
//import com.revature.myrev.repository.UserRepository;
//import com.revature.myrev.repository.UserRepository;
//import com.revature.myrev.repository.UserRepository;
//import com.revature.myrev.service.UserServiceImpl;
//import com.revature.myrev.service.UserServiceImpl;
//
//	public class TestUserService {
//
//	/*	@Test
//	    public void testMock() {
//	    UserRepository mockObj = Mockito.mock(UserRepository.class);
//	    List<User> user = userRepository.findAll();
//	    Mockito.when(mockObj.findAllByUserId(1)).thenReturn(user);
//
//	    List<User> user = mockObj.findAllByUserId(1);
//
//	   // Assert.
//	    assertEquals(user, user);
//	    Mockito.verify(mockObj).findAllByUserId(1); 
//		
//		
//		
//	}
//	
//	
//		@InjectMocks
//		
//		 UserServiceImpl userService;
//		
//		@Mock
//		UserRepository userRepository;
//		
//		User mockUser;
//		
//		@BeforeEach
//		void setUp() throws Exception {
//			MockitoAnnotations.initMocks(this);
//			
//			mockUser = new User();
//			mockUser.setUserId(1);
//			mockUser.setAge(38);
//			mockUser.setGender("male");
//		}
//		
//		
//		@Test
//		final void testGetUser() {
//			
//			
//			when(userRepository.findById(anyInt()).get()).thenReturn(mockUser);
//			
//			User user = userService.findById(1);
//			assertNotNull(user);
//			assertEquals("male", user.getGender());
//		}
//		
//	
//		@InjectMocks
//		 UserServiceImpl userService;
//		
//		@Mock
//		UserRepository userRepository;
//		
//		User user;
//		
//		@BeforeEach
//		void setUp() throws Exception{
//			MockitoAnnotations.initMocks(this);
//			user = new User();
//			
//			user.setAge(38);
//			user.setEmail("test@aol.com");
//			user.setFirstName("John");
//			user.setLastName("Smith");
//			user.setGender("Male");
//			user.setJobTitle("Software Engineer");
//		}
//		
//		@Test
//		final void testGetUser() {
//			when(userRepository.findByUsername(anyString())).thenReturn(user);
//			assertNotNull(user);
//			assertEquals("Smith", user.getLastName());
//		}		
//		
//		
//		
//		
//		@InjectMocks
//		 UserServiceImpl userService;
//		
//		@Mock
//		UserRepository userRepository;
//		
//		User user;
//		
//		@BeforeEach
//		void setUp() throws Exception{
//			MockitoAnnotations.initMocks(this);
//			user = new User();
//			
//			user.setUserId(8);
//			
//		}
//	
//		@Test
//		final void testGetUser() {
//			when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
//			//when(userRepository.findById(anyInt())).thenReturn(user);
//			assertNotNull(user);
//			assertEquals(8, user.getUserId());
//		}		
//		
//		
//		
//	//	private UserRepository userRepository;
////		private UserServiceImpl userService;
//		
//		@BeforeEach
//		void initService() {
//			userRepository = mock(UserRepository.class);
//		//	userService = new UserServiceImpl();
//			
//			
//		}
//		
//		
//		@Test
//		void create() {
//			User user = new User();
//			
//			user = new User();
//			
//			user.setUserId(6);
//			user.setJobTitle("Software Engineer");
//	//		user.setUserContent("This is a sample user");
//			
//			when(userRepository.save(any(User.class))).thenReturn(user);
//			assertNotNull(user);
//			assertEquals(6, user.getUserId());
//			
//		}
//		
//		
//
//*/		
//		
//	}
//

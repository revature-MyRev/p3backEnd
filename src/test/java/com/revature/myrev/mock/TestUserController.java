package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import com.revature.myrev.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.model.Users;

import com.revature.myrev.repository.UsersRepository;
import com.revature.myrev.service.UsersServiceImpl;

public class TestUserController {

	@InjectMocks
	UserController usersController;

	@Mock
	UsersServiceImpl usersService;

	Users users;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		users = new Users();

		users.setAge(38);
		users.setEmail("test@aol.com");
		users.setFirstName("John");
		users.setLastName("Smith");
		users.setGender("Male");
		users.setJobTitle("Software Engineer");
	}

	@Test
	final void testGetUsers() {
		when(usersService.findById(anyInt())).thenReturn(users);
		assertNotNull(users);
		assertEquals("Smith", users.getLastName());
	}

	private UsersRepository usersRepository;
//	private UsersServiceImpl usersService;

	@BeforeEach
	void initService() {
		usersRepository = mock(UsersRepository.class);
		// usersService = new UsersServiceImpl();

	}

	@Test
	void create() {
		Users users = new Users();

		// users = new Users();

		users.setUserId(6);

		when(usersRepository.save(any(Users.class))).thenReturn(users);
		assertNotNull(users);
		assertEquals(6, users.getUserId());

	}

	/*
	 * 
	 * 
	 * @InjectMocks UsersController usersController;
	 * 
	 * @Mock UsersServiceImpl usersService;
	 * 
	 * Users users;
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @BeforeEach void setUp() throws Exception{
	 * MockitoAnnotations.initMocks(this); users = new Users();
	 * 
	 * users.setUsersId(6); users.setUsersId(1);
	 * users.setJobTitle("This is a job Title");
	 * 
	 * }
	 * 
	 * @Test final void testGetUsers() {
	 * //when(usersService.findByUsersId(anyInt())).thenReturn(users);
	 * when(usersService.findAll()).thenReturn(Collections.singletonList(users));
	 * 
	 * assertNotNull(users); assertEquals(6, users.getUsersId()); }
	 */
}

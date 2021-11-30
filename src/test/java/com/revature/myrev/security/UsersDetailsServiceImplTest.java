package com.revature.myrev.security;

//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//import org.junit.After;
//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

/**
 * @author Dipanjali Ghosh
 *
 */
@SpringBootTest // -was working with this annotation before the merge conflict, will pass test
				// while commented out -> contextload test fails also, could be the cause
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
//@RunWith(MockitoJUnitRunner.class) - used with Junit 4 (still works)
//@ExtendWith(MockitoExtension.class)
class UsersDetailsServiceImplTest {

	/** Mock UserRespository for Mockito testing */
	// @Mock
	@Autowired
	private UsersRepository repository;
	/** UserService for JUnit testing */
	// @Spy
	@Autowired
	// @InjectMocks
	private UserDetailsService service = new UsersDetailsServiceImpl();
	/** Used for the initialization & closing of mocked fields */
//    private AutoCloseable closeable;
//	
//	@Before
//	public void setUp () {
//		closeable = MockitoAnnotations.openMocks(this);
//	}
//	
//	
//	@After
//	public void releaseMocks () throws Exception {
//		closeable.close();
//	}

	/**
	 * Test that findByUserName either finds a user or throws an exception
	 */
	@Test
	void testFindByUsername() {
		// set up repository
		Users one = new Users(1, 30, "test123", "testpassword", "gender", "photo", "email", "firstName", "lastName",
				"middleName", "jobTitle");
		Users two = new Users(2, 35, "num123", "passwordtest", "gender", "photo", "email", "firstName", "lastName",
				"middleName", "jobTitle");
		Users three = new Users(3, 45, "fakeusername", "fakepassword", "gender", "photo", "email", "firstName",
				"lastName", "middleName", "jobTitle");

		repository.save(one);
		repository.save(two);
		repository.save(three);

		// test for exception on empty table
		// when(repository.findByUserName("user1")).thenReturn(null);

		try {
			Users test = (Users) service.loadUserByUsername("user1");
		} catch (Exception e) {
			Assertions.assertNull(e.getMessage());
			// verify(service,times(1)).loadUserByUsername("user1");
		}

		// test for exception on invalid username on nonempty table
		List<Users> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);

		try {
			Users test = (Users) service.loadUserByUsername("user1");
		} catch (Exception e) {
			Assertions.assertNull(e.getMessage());
			// verify(service,times(1)).loadUserByUsername("user1");
		}

		// test for returned user on valid username
		// when(repository.findByUserName("test123")).thenReturn(one); //mock
		// UsersDetailsServiceImpl to call findByUserName and return matching user

		UsersDetailsImpl test = (UsersDetailsImpl) service.loadUserByUsername("test123");

		Assertions.assertNotNull(test);
		// Assertions.assertEquals(30, test.getAge()); //age should match returned user
		// age
		Assertions.assertEquals("testpassword", test.getPassword()); // password should match returned user password
		// verify(service,times(1)).loadUserByUsername("test123"); //verify
		// UsersDetailsServiceImpl calls findByUserName method 1 time
	}

}

package com.revature.myrev.service; 

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

	/** Mock UserRespository for Mockito testing */
	@Mock
	private UsersRepository repository;
	/** UserService for JUnit testing */
	@Spy
	@Autowired
	@InjectMocks
	private UsersService service = new UsersServiceImpl();
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
	public void testFindByUsername () {
		
		//test for returned user on valid username
		List<Users> list = new ArrayList<>();
		Users one = new Users(1, 30, "test123", "testpassword", "gender", "photo", "email", "firstName", "lastName", "middleName", "jobTitle");
		Users two = new Users(2, 35, "num123", "passwordtest", "gender", "photo", "email", "firstName", "lastName", "middleName", "jobTitle");
		Users three = new Users(3, 45, "fakeusername", "fakepassword", "gender", "photo", "email", "firstName", "lastName", "middleName", "jobTitle");
		list.add(one);
		list.add(two);
		list.add(three);

					
		when(repository.findByUserName("test123")).thenReturn(one);			//mock UsersServiceImpl to call findByUserName and return matching user
		
		Users test = service.findByUserName("test123");	
		
		Assertions.assertEquals(30, test.getAge());							//age should match returned user age
		Assertions.assertEquals("testpassword", test.getPassword());		//password should match returned user password
		verify(service,times(1)).findByUserName("test123");					//verify UsersServiceImpl calls findByUserName method 1 time
		
		
		//test for exception on empty table
		//test for exception on invalid username
		
	}


}

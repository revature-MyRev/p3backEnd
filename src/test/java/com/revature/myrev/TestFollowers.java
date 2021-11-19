package com.revature.myrev;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.myrev.model.Follower;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.FollowerRepository;
import com.revature.myrev.repository.UsersRepository;
import com.revature.myrev.service.FollowerService;
import com.revature.myrev.service.FollowerServiceImpl;
import com.revature.myrev.service.UsersService;
import com.revature.myrev.service.UsersServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestFollowers {	
	
	@Mock
	private FollowerRepository followerRepository;
	@Mock
	private UsersRepository usersRepository;
	@InjectMocks
	private UsersServiceImpl usersService;
	@InjectMocks
	private FollowerServiceImpl followerService;
	
	@Before
	void setup(){
		
		Users testUser1 = new Users(0, 15, "JakeTheDog", "passw0rd", "male", "https://meme.io", "swag@gmail.com",
				"Jake", "Dog",  "The", "Dog");
		Users testUser2 = new Users(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "swag@gmail.com",
				"Fin", "Human",  "The", "Human");
		
		usersRepository.save(testUser1);
		usersRepository.save(testUser2);
		
		Follower follow = new Follower(0, 0, 1);
		
		followerRepository.save(follow);
	}
	
	@Test
	void testFindFollowers() {
		List<Users> actualUsersList = null;
		List<Users> expectedUsersList = new ArrayList<Users>();
		
		actualUsersList = usersService.findAll();
		 
		
		Users expectedUser1 = new Users(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		Users expectedUser2 = new Users(0, 15, "JakeTheDog", "passw0rd", "male", "https://meme.io", "swag@gmail.com",
				"Jake", "Dog",  "The", "Dog");
		
		expectedUsersList.add(expectedUser1);
		expectedUsersList.add(expectedUser2);
		

		for (Users actualUser: actualUsersList) {
			//actualUserList may not be in the same order as the expectedUserList
			if (expectedUsersList.contains(actualUser)) {
				expectedUsersList.remove(actualUser);
			}
			else {
				Assert.fail("acutalUser : " + actualUser.toString() + " does not exist in expectedUsers list");
			}
		}
		
	}
	
	@Test
	void testFindFolllowerByUserName() {
		Users actualUser = null;
		
		/*
		 * acutalUser = user.findFollowers(followed_id);
		 */
		
		Users expectedUser = new Users(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		

		
		Assert.assertEquals(expectedUser, actualUser);
	}
	
	@Test
	void testFindFollowerById() {
		
		Users actualUsers = null;
		
		/*
		 * acutalUser = user.findFollowers(followed_id);
		 */
		
		Users expectedUsers = new Users(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		

		
		Assert.assertEquals(expectedUsers, actualUsers);
	}
}
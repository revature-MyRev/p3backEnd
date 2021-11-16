package com.revature.myrev;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.myrev.model.Follower;
import com.revature.myrev.model.User;
import com.revature.myrev.repository.FollowerRepository;
import com.revature.myrev.repository.UserRepository;
import com.revature.myrev.service.FollowerService;
import com.revature.myrev.service.UserService;

public class TestFollowers {	
	
	@Mock
	private FollowerRepository followerRepository;
	
	@Mock
	private UserRepository userRepository;
	
	private UserService userService;
	
	private FollowerService followerService;
	
	@Before
	void setup(){
		
		this.userService = new UserService();
		this.followerService = new FollowerService();
		
		this.userRepository = Mockito.mock(UserRepository.class);
		this.followerRepository = Mockito.mock(FollowerRepository.class);
		
		this.userService.repository = this.userRepository;
		this.followerService.repository = this.followerRepository;
		
		User testUser1 = new User(0, 15, "JakeTheDog", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Jake", "Dog",  "The", "Dog");
		User testUser2 = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		
		userRepository.save(testUser1);
		userRepository.save(testUser2);
		
		Follower follow = new Follower(0, 0, 1);
		
		followerRepository.save(follow);
	}
	
	@Test
	void testFindFollowersByPartialUserName() {
		ArrayList<User> actualUserList = null;
		ArrayList<User> expectedUserList = new ArrayList<User>();
		/*
		 * acutalUserList = user.findFollowersByPartialUserName(followed_id);
		 */
		
		User expectedUser1 = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		User expectedUser2 = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");

		for (User actualUser: actualUserList) {
			//actualUserList may not be in the same order as the expectedUserList
		}
		
	}
	
	@Test
	void testFindFolllowerByUserName() {
		User actualUser = null;
		
		/*
		 * acutalUser = user.findFollowers(followed_id);
		 */
		
		User expectedUser = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		

		
		Assert.assertEquals(expectedUser, actualUser);
	}
	
	@Test
	void testFindFollowerById() {
		
		User actualUser = null;
		
		/*
		 * acutalUser = user.findFollowers(followed_id);
		 */
		
		User expectedUser = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		

		
		Assert.assertEquals(expectedUser, actualUser);
	}
}

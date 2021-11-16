package com.revature.myrev;

import java.util.ArrayList;

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

public class TestSearch {
	
	@Mock
	private UserRepository userRepository;
	
	private UserService userService;

	
	@Before
	void setup() {
		
		userRepository = Mockito.mock(UserRepository.class);
		
		User testUser1 = new User(0, 15, "JakeTheDog", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Jake", "Dog",  "The", "Dog");
		User testUser2 = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		User testUser3 = new User(0, 15, "JakeTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Jake", "Dog",  "The", "Dog");
		User testUser4 = new User(1, 16, "FinTheDog", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		
		userRepository.save(testUser1);
		userRepository.save(testUser2);
		userRepository.save(testUser3);
		userRepository.save(testUser4);
		
	}
	
	@Test
	void testFindFollowersByPartialUserName() {
		ArrayList<User> actualUserList = null;
		ArrayList<User> expectedUserList = new ArrayList<User>();
		
		//acutalUserList = user.findFollowersByPartialUserName("Fin");
		
		User expectedUser1 = new User(1, 16, "FinTheHuman", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");
		User expectedUser2 = new User(1, 16, "FinTheDog", "passw0rd", "male", "https://meme.io", "sawg@gmail.com",
				"Fin", "Human",  "The", "Human");

		for (User actualUser: actualUserList) {
			//actualUserList may not be in the same order as the expectedUserList
		}
		
	}
}

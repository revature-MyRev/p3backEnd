package com.revature.myrev.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.myrev.model.Follower;
import com.revature.myrev.repository.FollowerRepository;
import com.revature.myrev.service.FollowerServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FollowersServiceTest{
	
	final static Logger logger = LoggerFactory.getLogger(FollowersServiceTest.class);
	
	@MockBean
	private FollowerRepository followerRepository;
	
	@Autowired
	FollowerServiceImpl followerService = new FollowerServiceImpl();

	Follower follower1;
	Follower follower2;
	
	ArrayList<Follower> followers;
	
	@Test
	void testFindByFollowedId() {
		follower1 = new Follower(1,1,2);
		follower2 = new Follower(2,2,1);
		followers = new ArrayList<Follower>();
		followers.add(follower1);
		followers.add(follower2);
		when(followerRepository.findByFollowedId(1)).thenReturn(followers);	
		assertEquals(followerService.findByFollowedId(1).size(), followers.size());
	}

	@Test
	void testFindAll() {
		follower1 = new Follower(1,1,2);
		follower2 = new Follower(2,2,1);
		followers = new ArrayList<Follower>();
		followers.add(follower1);
		followers.add(follower2);
		when(followerRepository.findAll()).thenReturn(followers);
		assertEquals(2, followerService.findAll().size());
	}

	@Test
	void testFindById() {
		follower1 = new Follower(1,1,2);
		Optional<Follower> follower2Optional = Optional.of(follower1);
		followers = new ArrayList<Follower>();
		followers.add(follower1);
		followers.add(follower2);
		when(followerRepository.findById(1)).thenReturn(follower2Optional);
		assertEquals(followerService.findById(1).toString(),follower1.toString());
	}

	@Test
	void testSave() {
		follower1 = new Follower(1,1,2);
		Optional<Follower> follower2Optional = Optional.of(follower1);
		when(followerRepository.findById(1)).thenReturn(follower2Optional);
		followerService.save(follower1);
	    assertEquals(followerService.findById(1).toString(),follower1.toString());	
	}

	@Test
	void testUpdate() {
		follower1 = new Follower(1,1,2);
		follower1.setFollowedId(3);
		follower2 = follower1;
		Optional<Follower> follower2Optional = Optional.of(follower2);
		when(followerRepository.findById(1)).thenReturn(follower2Optional);		
		followerService.save(follower2);
	    assertEquals(followerService.findById(1).toString(),follower1.toString());	
	}

	@Test
	void testDeleteById() {
		follower1 = new Follower(1,1,2);
		follower2 = new Follower(2,2,1);
		followers = new ArrayList<Follower>();
		followers.add(follower1);
		followers.add(follower2);
		followerService.save(follower1);
		followerService.save(follower2);
		when(followerRepository.findAll()).thenReturn(followers);
		assertEquals(followers.size(), 2);
		followerRepository.deleteById(1);
		followers.remove(1);
		when(followerRepository.findAll()).thenReturn(followers);
		assertEquals(followers.size(), 1);
	}

	@Test
	void testFindByFollowedIdAndFollowerId() {
		follower1 = new Follower(1,1,2);
		follower2 = new Follower(2,2,1);
		
		followers = new ArrayList<Follower>();
		
		followers.add(follower1);
		followers.add(follower2);
		
		when(followerRepository.findByFollowedIdAndFollowerId(1, 2)).thenReturn(follower1);
		
		assertEquals(followerService.findByFollowedIdAndFollowerId(1, 2).toString(),follower1.toString());
	}
}
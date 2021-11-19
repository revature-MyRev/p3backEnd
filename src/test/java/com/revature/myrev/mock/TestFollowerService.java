package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.myrev.model.Follower;
import com.revature.myrev.repository.FollowerRepository;


public class TestFollowerRepository {
	/*
	public void testMockFollowedBy() {
		FollowerRepository mockObj = Mockito.mock(FollowerRepository.class);
		Follower follower = FollowerRepository.findByFollowedId(1);
		Mockito.when(mockObj.findByFollowedId(1))thenReturn(followers);
		
		List<Follower> mockFollowers = mockObj.findByFollowedId(1);
		
		assertEquals(followers, mockFollowers);
		Mockito.verify(mockObj).findByFollowedId(1);
	}
	
	public void testFindAllMock() {
		FollowerRepository mockObj = Mockito.mock(FollowerRepository.class);
	    List<Follower> follower = FollowerRepository.findAll();
	    Mockito.when(mockObj.findByFollowedId(1)).thenReturn(follower);

	    List<Follower> order = mockObj.findByFollowedId(1);

	   // Assert.
	    assertEquals(follower, order);
	    Mockito.verify(mockObj).findByFollowedId(1); 
	}
	*/
	@Test
	public void followerFindByIdMock()  {
	    FollowerRepository localMockFollowerRepository = Mockito.mock(FollowerRepository.class);
	    JpaRepository<Follower, Integer> followerRepository = null;
		//   FollowerRepository followerRepository = new FollowerRepository();
	 	List<Follower> followers = followerRepository.findAll();
		
	    Mockito.when(localMockFollowerRepository.findAll()).thenReturn(followers);

	    List<Follower> mockFollowers= localMockFollowerRepository.findAll();

	    //Assert.
	    assertEquals(followers, mockFollowers);
	    Mockito.verify(localMockFollowerRepository).count();
	}
}



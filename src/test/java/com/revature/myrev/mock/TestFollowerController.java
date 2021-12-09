package com.revature.myrev.mock;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.controller.FollowerController;
import com.revature.myrev.model.Follower;
import com.revature.myrev.service.FeedServiceImpl;

public class TestFollowerController {
	@InjectMocks
	FollowerController followerController;

	@Mock
	FeedServiceImpl followerService;

	Follower follower;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		follower = new Follower();

		follower.setFollowedId(3);
		follower.setFollowerId(1);
		follower.setId(2);

	}

//	@Test
//	final void testGetFollower() {
//		when(followerService.findById(anyInt())).thenReturn(follower);
//		assertNotNull(follower);
//		assertEquals(2, follower.getId());
//	}
}

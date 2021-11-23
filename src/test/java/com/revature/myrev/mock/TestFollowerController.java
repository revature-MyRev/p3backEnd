package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

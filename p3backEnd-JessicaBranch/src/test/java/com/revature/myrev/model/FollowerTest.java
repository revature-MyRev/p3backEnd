package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FollowerTest {

	@Test
	void followerConstructorTest() {
		Follower testFollower = new Follower();
		assertNotNull(testFollower, "testFollower is null");
	}

	@Test
	void followerIdGetterTest() {
		Follower testFollower = new Follower();
		assertEquals(0, testFollower.getId());
	}

	@Test
	void followerIdSetterTest() {
		int test = 1;
		Follower testFollower = new Follower();
		testFollower.setId(1);
		assertEquals(test, testFollower.getId());
	}

	@Test
	void followerFollowerIdGetterTest() {
		Follower testFollower = new Follower();
		assertEquals(0, testFollower.getFollowerId());
	}

	@Test
	void followerFollowerIdSetterTest() {
		int test = 1;
		Follower testFollower = new Follower();
		testFollower.setFollowerId(1);
		assertEquals(test, testFollower.getFollowerId());
	}

	@Test
	void followerFollowedIdGetterTest() {
		Follower testFollower = new Follower();
		assertEquals(0, testFollower.getFollowedId());
	}

	@Test
	void followerFollowedIdSetterTest() {
		int test = 1;
		Follower testFollower = new Follower();
		testFollower.setFollowedId(1);
		assertEquals(test, testFollower.getFollowedId());
	}

	@Test
	void followerToStringTest() {
		String test = "Follower [id=" + "0" + ", followerId=" + "0" + ", followedId=" + "0" + "]";
		Follower testFollower = new Follower();
		assertEquals(0, testFollower.toString().compareTo(test));
	}

	@Test
	void followerConstructorWithParamsTest() {
		int id = 1;
		int followerId = 1;
		int followedId = 1;
		String test = "Follower [id=" + id + ", followerId=" + followerId + ", followedId=" + followedId + "]";
		Follower testFollower = new Follower(id, followerId, followedId);
		assertEquals(0, testFollower.toString().compareTo(test));
	}
}

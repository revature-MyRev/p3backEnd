package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FeedTest {

	void feedConstructorTest() {
		Feed testFeed = new Feed();
		assertNotNull(testFeed, "testFeed is null");
	}

	@Test
	void feedIdGetterTest() {
		Feed testFeed = new Feed();
		assertEquals(0, testFeed.getFeedId());
	}

	@Test
	void feedIdSetterTest() {
		int test = 1;
		Feed testFeed = new Feed();
		testFeed.setFeedId(test);
		assertEquals(test, testFeed.getFeedId());
	}

	@Test
	void feedToStringTest() {
		int feedId = 0;
		String test = "Feed [feedId=" + feedId + "]";
		Feed testFeed = new Feed();
		assertEquals(0, testFeed.toString().compareTo(test));
	}

	@Test
	void feedConstructorWithParamsTest() {
		int feedId = 9;
		String test = "Feed [feedId=" + feedId + "]";
		Feed testFeed = new Feed(9);
		assertEquals(0, testFeed.toString().compareTo(test));
	}

}

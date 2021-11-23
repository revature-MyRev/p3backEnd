package com.revature.myrev.repository;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Feed;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class FeedRepositoryTest {
// Not mocking anything here.

	// Be sure to delete any additions made to db tables at the end of each test
	/** FeedRepository for testing */
	@Autowired
	private FeedRepository repository;

	@Test
	@Order(1)
	public void createFeedTest() {
		Feed feed = new Feed(1);

		Feed result = repository.save(feed);

		Assertions.assertNotEquals(0, result.getFeedId());
	}

	@Test
	@Order(2)

	public void updateFeedTest() {
		List<Feed> feeds = repository.findAll();
		Feed updateMe = feeds.get(feeds.size() - 1);
		updateMe.setFeedId(2);
		Feed result = repository.save(updateMe);

		Assertions.assertEquals(2, result.getFeedId());
	}

	@Test
	@Order(3)

	public void findFeedByFeedIdTest() {
		Feed result = new Feed(1);

		Assertions.assertNotEquals(0, result.getFeedId());
	}

	@Test
	@Order(4)

	public void deleteTest() {
		List<Feed> feeds = repository.findAll();
		Feed deleteMe = feeds.get(feeds.size() - 1);
		repository.deleteById(deleteMe.getFeedId());

		Assertions.assertEquals(null, repository.findById(deleteMe.getFeedId()));
	}

	@Test
	@Order(5)

	public void findAllFeedsTest() {
		Feed test = new Feed();
		List<Feed> feeds = repository.findAll();

		Assertions.assertNotEquals(0, feeds.size());
	}
}

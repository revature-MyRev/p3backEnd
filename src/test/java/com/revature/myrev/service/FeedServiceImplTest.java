package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Feed;
import com.revature.myrev.repository.FeedRepository;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
class FeedServiceImplTest {

	/** Mock FeedRespository for Mockito testing */
	@Mock
	private FeedRepository repository;
	/** FollowerService for JUnit testing */
	@Autowired
	@InjectMocks
	FeedService feedServ = new FeedServiceImpl();
	/** Used for the initialization & closing of mocked fields */
	private AutoCloseable closeable;

	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@After
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test
	@Order(1)
	public void createFeedTest() {
		Feed feed = new Feed(1);

		int result = feedServ.save(feed);

		Assertions.assertEquals(1, result);
	}

	@Test
	@Order(2)

	public void updateFeedTest() {
		List<Feed> feeds = feedServ.findAll();
		Feed updateMe = feeds.get(feeds.size() - 1);
		updateMe.setFeedId(2);
		int result = feedServ.save(updateMe);

		Assertions.assertEquals(2, result);
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
		Feed feed = new Feed();
		List<Feed> feeds = feedServ.findAll();
		Feed deleteMe = feeds.get(feeds.size() - 1);
		feedServ.deleteById(deleteMe.getFeedId());

		Assertions.assertEquals(null, feedServ.findById(deleteMe.getFeedId()));
	}

	@Test
	@Order(5)

	public void findAllFeedsTest() {
		Feed test = new Feed();
		List<Feed> feeds = feedServ.findAll();

		Assertions.assertNotEquals(0, feeds.size());
	}

}

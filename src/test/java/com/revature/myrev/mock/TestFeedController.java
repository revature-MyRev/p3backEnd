package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.myrev.model.Feed;
import com.revature.myrev.repository.FeedRepository;

public class TestFeedController {
	/*
	 * @InjectMocks ThreadController threadController;
	 * 
	 * @Mock ThreadServiceImpl threadService;
	 * 
	 * Thread comments;
	 * 
	 * @BeforeEach void setUp() throws Exception{
	 * MockitoAnnotations.initMocks(this); comments = new Thread();
	 * 
	 * comments.setThreadId(5);
	 * 
	 * }
	 * 
	 * @Test final void testGetThread() { //
	 * when(threadService.findById(anyInt())).thenReturn(comments);
	 * when(threadService.findAll()).thenReturn(Collections.singletonList(comments))
	 * ;
	 * 
	 * 
	 * assertNotNull(comments); assertEquals(5, comments.getThreadId()); }
	 * 
	 * Thread t = null; ThreadService service = mock(ThreadService.class); /*
	 * 
	 * @BeforeEach public void setUp(){ t= new Thread(service); }
	 */

	private FeedRepository feedRepository;
//	private ThreadServiceImpl threadService;

	@BeforeEach
	void initService() {
		feedRepository = mock(FeedRepository.class);
		// threadService = new ThreadServiceImpl();

	}

	@Test
	void create() {
		Feed feed = new Feed();

		// thread = new Thread();

		feed.setFeedId(6);

		when(feedRepository.save(any(Feed.class))).thenReturn(feed);
		assertNotNull(feed);
		assertEquals(6, feed.getFeedId());

	}

}

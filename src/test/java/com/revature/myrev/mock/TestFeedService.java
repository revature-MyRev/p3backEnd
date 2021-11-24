package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.myrev.model.Feed;
import com.revature.myrev.repository.FeedRepository;
import com.revature.myrev.service.FeedServiceImpl;


public class TestFeedService {
/*
	@Mock
	ThreadRepository threadRepository;
	
	//Optional<Thread> thread;
	
	@Test
    public void testMock() {
    ThreadRepository mockObj = Mockito.mock(ThreadRepository.class);
    List<Thread> threads = threadRepository.findAll();
    Mockito.when(mockObj.findAll()).thenReturn(threads);

    List<Thread> mockThreads = mockObj.findAll();

   // Assert.
    assertEquals(threads, mockThreads);
    Mockito.verify(mockObj).findAll(); 
	}
	
	@Test
	final void testFindById() {
		when(threadRepository.findById(1)).thenReturn(thread);
	}
	
	
	@Test
	public void threadFindByIdMock()  {
	    ThreadRepository localMockThreadRepository = Mockito.mock(ThreadRepository.class);
	    JpaRepository<Thread, Integer> threadRepository = null ;//new JpaRepository<Thread, Integer>();;
		//   ThreadRepository threadRepository = new ThreadRepository();
	 	List<Thread> threads = threadRepository.findAll();
		
	    Mockito.when(localMockThreadRepository.findAll()).thenReturn(threads);

	    List<Thread> mockThreads= localMockThreadRepository.findAll();

	    //Assert.
	    assertEquals(threads, mockThreads);
	    Mockito.verify(localMockThreadRepository).count();
	}
	
	*/

	@InjectMocks
	 FeedServiceImpl threadService;
	
	@Mock
	FeedRepository feedRepository;
	
	Feed feed;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		feed = new Feed();
		
		feed.setFeedId(8);
		
	}
	
	@Test
	final void testGetThread() {
		when(feedRepository.findAll()).thenReturn(Collections.singletonList(feed));
		//when(threadRepository.findById(anyInt())).thenReturn(thread);
		assertNotNull(feed);
		assertEquals(8, feed.getFeedId());
	}		
	

	
	
}

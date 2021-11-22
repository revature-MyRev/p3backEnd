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

import com.revature.myrev.model.Thread;
import com.revature.myrev.repository.ThreadRepository;
import com.revature.myrev.service.ThreadServiceImpl;


public class TestThreadService {
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
	 ThreadServiceImpl threadService;
	
	@Mock
	ThreadRepository threadRepository;
	
	Thread thread;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		thread = new Thread();
		
		thread.setThreadId(8);
		
	}
	
	@Test
	final void testGetThread() {
		when(threadRepository.findAll()).thenReturn(Collections.singletonList(thread));
		//when(threadRepository.findById(anyInt())).thenReturn(thread);
		assertNotNull(thread);
		assertEquals(8, thread.getThreadId());
	}		
	

	
	
}

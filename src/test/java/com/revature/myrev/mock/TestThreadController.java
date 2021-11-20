package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.controller.ThreadController;
import com.revature.myrev.model.Thread;
import com.revature.myrev.model.Thread;
import com.revature.myrev.repository.ThreadRepository;
import com.revature.myrev.service.ThreadService;
import com.revature.myrev.service.ThreadServiceImpl;

public class TestThreadController {
/*
	@InjectMocks
	ThreadController threadController;
	
	@Mock
	ThreadServiceImpl threadService;
	
	Thread comments;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		comments = new Thread();
		
		comments.setThreadId(5);
		
	}
	
	@Test
	final void testGetThread() {
	//	when(threadService.findById(anyInt())).thenReturn(comments);
		when(threadService.findAll()).thenReturn(Collections.singletonList(comments));
		
		
		assertNotNull(comments);
		assertEquals(5, comments.getThreadId());
	}
	
	Thread t = null;
	ThreadService service = mock(ThreadService.class);
/*	
	@BeforeEach
	public void setUp(){
		t= new Thread(service);
	}
*/	
		

	private ThreadRepository threadRepository;
//	private ThreadServiceImpl threadService;
	
	@BeforeEach
	void initService() {
		threadRepository = mock(ThreadRepository.class);
	//	threadService = new ThreadServiceImpl();
		
		
	}
	
	
	@Test
	void create() {
		Thread thread = new Thread();
		
	//	thread = new Thread();
		
		thread.setThreadId(6);
	
		when(threadRepository.save(any(Thread.class))).thenReturn(thread);
		assertNotNull(thread);
		assertEquals(6, thread.getThreadId());
		
	}
	
	
}

	
	
	
	
	


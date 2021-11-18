package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.myrev.model.Thread;
import com.revature.myrev.repository.ThreadRepository;


public class TestThreadRepository {
	
	/*
	@Test
    public void testMock() {
    ThreadRepository mockObj = Mockito.mock(ThreadRepository.class);
    List<Thread> thread = threadRepository.findAll();
    Mockito.when(mockObj.findAllByorderId(1)).thenReturn(thread);

    List<Thread> order = mockObj.findAllByorderId(1);

   // Assert.
    assertEquals(thread, order);
    Mockito.verify(mockObj).findAllByorderId(1); 
    */
	
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
}

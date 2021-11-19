package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreadTest {

	@Test
	void threadConstructorTest() {
		Thread testThread = new Thread();
		assertNotNull(testThread, "testThread is null");
	}

	@Test
	void threadIdGetterTest() {
		Thread testThread = new Thread();
		assertEquals(0, testThread.getThreadId());
	}

	@Test
	void threadIdSetterTest() {
		int test = 1;
		Thread testThread = new Thread();
		testThread.setThreadId(test);
		assertEquals(test, testThread.getThreadId());
	}

	@Test
	void threadToStringTest() {
		int threadId = 0;
		String test = "Thread [threadId=" + threadId + "]";
		Thread testThread = new Thread();
		assertEquals(0, testThread.toString().compareTo(test));
	}

	@Test
	void threadConstructorWithParamTest() {
		int threadId = 1;
		String test = "Thread [threadId=" + threadId + "]";
		Thread testThread = new Thread(threadId);
		assertEquals(0, testThread.toString().compareTo(test));
	}
}

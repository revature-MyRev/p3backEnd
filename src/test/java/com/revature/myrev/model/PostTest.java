package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class PostTest {

	@Test
	void postConstructorTest() {
		Post testPost = new Post();
		assertNotNull(testPost, "testPost is null");
	}

	@Test
	void postIdGetterTest() {
		Post testPost = new Post();
		assertEquals(0, testPost.getPostId());
	}

	@Test
	void postIdSetterTest() {
		int test = 1;
		Post testPost = new Post();
		testPost.setPostId(test);
		assertEquals(test, testPost.getPostId());
	}

	@Test
	void postContentGetterTest() {
		Post testPost = new Post();
		assertNull(testPost.getPostContent(), "testPost.postContent is not null");
	}

	@Test
	void postContentSetterTest() {
		String test = "Hello, world!";
		Post testPost = new Post();
		testPost.setPostContent(test);
		assertEquals(0, testPost.getPostContent().compareTo(test));
	}

	@Test
	void postUserIdGetterTest() {
		Post testPost = new Post();
		assertEquals(0, testPost.getUserId());
	}

	@Test
	void postUserIdSetterTest() {
		int test = 1;
		Post testPost = new Post();
		testPost.setUserId(test);
		assertEquals(test, testPost.getUserId());
	}

	@Test
	void postDateGetterTest() {
		Post testPost = new Post();
		assertNull(testPost.getPostDate(), "testPost.postDate is not null");
	}

	@Test
	void postDateSetterTest() {
		Date test = new Date(System.currentTimeMillis());
		Post testPost = new Post();
		testPost.setPostDate(test);
		assertEquals(test, testPost.getPostDate());
	}

//	@Test
//	void postThreadIdGetterTest() {
//		// TODO uncomment when getThreadId() is made and remove the fail statement
////		fail("Currently, getThreadId method does not exist");
//		Post testPost = new Post();
//		assertEquals(0, testPost.getThreadId());
//	}

//	@Test
//	void postThreadIdSetterTest() {
//		// TODO uncomment when setThreadId() is made and remove the fail statement
////		fail("Currently, setThreadId method does not exist");
//		int test = 1;
//		Post testPost = new Post();
//		testPost.setThreadId(test);
//		assertEquals(test, testPost.getThreadId());
//	}

//	@Test
//	void postImageUrlGetterTest() {
//		// TODO uncomment when getImageUrl() is made and remove the fail statement
////		fail("Currently, getImageUrl method does not exist");
//		Post testPost = new Post();
//		assertNull(testPost.getImageUrl(), "testPost.imageUrl is not null");
//	}

//	@Test
//	void postImageUrlSetterTest() {
//		// TODO uncomment when setImageUrl() is made and remove the fail statement
////		fail("Currently, setImageUrl method does not exist");
//		String test = "testImage.jpg";
//		Post testPost = new Post();
//		testPost.setImageUrl(test);
//		assertEquals(0, testPost.getImageUrl().compareTo(test);
//	}

	@Test
	void postToStringTest() {
		// TODO edit to include missing data members and remove fail statement
		int postId = 0;
		String postContent = "null";
		int userId = 0;
		String postDate = "null";
//		int threadId = 0;
//		String imageUrl = "null";
		String test = "Post [postId=" + postId + ", postContent=" + postContent + ", userId=" + userId + ", postDate="
				+ postDate + "]";
		Post testPost = new Post();
		assertEquals(0, testPost.toString().compareTo(test));
//		fail("Currently, toString method does not include threadId and imageUrl");
	}

	@Test
	void postConstructorWithParamsTest() {
		// TODO edit to include missing data members and remove fail statement
		int postId = 1;
		String postContent = "Hello, World!";
		int userId = 1;
		Date postDate = new Date(System.currentTimeMillis());
//		int threadId = 0;
//		String imageUrl = "null";
		String test = "Post [postId=" + postId + ", postContent=" + postContent + ", userId=" + userId + ", postDate="
				+ postDate + "]";
		Post testPost = new Post(postId, postContent, userId, postDate);
		assertEquals(0, testPost.toString().compareTo(test));
//		fail("Currently, Constructor with Parameters does not include threadId and imageUrl");
	}
}

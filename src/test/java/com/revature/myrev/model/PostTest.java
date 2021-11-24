package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import org.junit.jupiter.api.Test;

class PostTest {

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
		assertEquals(0, testPost.getUsersId());
	}

	@Test
	void postUserIdSetterTest() {
		int test = 1;
		Post testPost = new Post();
		testPost.setUsersId(test);
		assertEquals(test, testPost.getUsersId());
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

	@Test
	void postThreadIdGetterTest() {
		Post testPost = new Post();
		assertEquals(0, testPost.getFeedId());
	}

	@Test
	void postThreadIdSetterTest() {
		int test = 1;
		Post testPost = new Post();
		testPost.setFeedId(test);
		assertEquals(test, testPost.getFeedId());
	}

	@Test
	void postImageUrlGetterTest() {
		Post testPost = new Post();
		assertEquals(null, testPost.getImageUrl());
	}

	@Test
	void postImageUrlSetterTest() {
		String test = "coolpic.jpg";
		Post testPost = new Post();
		testPost.setImageUrl(test);
		assertEquals(test, testPost.getImageUrl());
	}

	@Test
	void postToStringTest() {

		int postId = 0;
		String postContent = "null";
		int usersId = 0;
		String postDate = "null";
		int threadId = 0;
		String imageUrl = "null";
		String type = "null";
		String test = "Post [postId=" + postId + ", postContent=" + postContent + ", usersId=" + usersId + ", postDate="
				+ postDate + ", threadId=" + threadId + ", imageUrl=" + imageUrl + ", type=" + type + "]";
		Post testPost = new Post();
		assertEquals(0, testPost.toString().compareTo(test));
	}

	@Test
	void postConstructorWithParamsTest() {

		int postId = 1;
		String postContent = "Hello, World!";
		int usersId = 1;
		Date postDate = new Date(System.currentTimeMillis());
		int threadId = 0;
		String imageUrl = "image";
		String type = "post";
		String test = "Post [postId=" + postId + ", postContent=" + postContent + ", usersId=" + usersId + ", postDate="
				+ postDate + ", threadId=" + threadId + ", imageUrl=" + imageUrl + ", type=" + type + "]";
		Post testPost = new Post(postId, postContent, usersId, postDate, imageUrl, threadId, type);
		assertEquals(0, testPost.toString().compareTo(test));
	}
}

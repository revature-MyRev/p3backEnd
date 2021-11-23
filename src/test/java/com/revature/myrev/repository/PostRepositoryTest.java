package com.revature.myrev.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Post;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PostRepositoryTest {
// Not mocking anything here.

	// Be sure to delete any additions made to db tables at the end of each test
	/** PostRepository for testing */
	@Autowired
	private PostRepository repository;

	@Test
	@Order(1)
	public void createPostTest() {
		Post post = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Post result = repository.save(post);

		Assertions.assertNotEquals(0, result.getPostId());
	}

	@Test
	@Order(2)

	public void updatePostTest() {
		List<Post> posts = repository.findAll();
		Post updateMe = posts.get(posts.size() - 1);
		updateMe.setPostContent("Updated Content");
		Post result = repository.save(updateMe);

		Assertions.assertEquals("Updated Content", result.getPostContent());
	}

	@Test
	@Order(3)

	public void findPostByPostIdTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getPostId());
	}

	@Test
	@Order(4)

	public void findPostByUserIdTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getUsersId());
	}

	@Test
	@Order(5)

	public void findPostByDateTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getPostDate());
	}

	@Test
	@Order(6)

	public void deleteTest() {
		List<Post> posts = repository.findAll();
		Post deleteMe = posts.get(posts.size() - 1);
		repository.deleteById(deleteMe.getPostId());

		Assertions.assertEquals(Optional.empty(), repository.findById(deleteMe.getPostId()));
	}

	@Test
	@Order(7)

	public void findAllPostsTest() {
		Post test = new Post();
		List<Post> posts = repository.findAll();
		Assertions.assertNotEquals(0, posts.size());
	}

//	@Test
//	@Order(7)
//	
//	public void likePostTest() {
//		List<Post> posts = repository.findAll();
//		Post likeMe = posts.get(posts.size()-1);
//		
//		// int likeCount +1
//		boolean result = repository.likePost(likeMe);
//
//		Assertions.assertEquals(true, result);
//	}
//	
//	@Test
//	@Order(8)
//	
//	public void dislikePostTest() {
//		List<Post> posts = repository.findAll();
//		Post dislikeMe = posts.get(posts.size()-1);
//		
//		// int likeCount -1
//		boolean result = repository.dislikePost(dislikeMe);
//
//		Assertions.assertEquals(true, result);
//		
//	}
}

package com.revature.myrev.service;

import java.sql.Date;
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
import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;

@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
class PostServiceImplTest {

	/** Mock PostRespository for Mockito testing */
	@Mock
	private PostRepository repository;
	/** PostService for JUnit testing */
	@Autowired
	@InjectMocks
	PostService postServ = new PostServiceImpl();
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
	@Rollback(value = false)
	public void createPostTest() {
		Post post = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Post result = postServ.savePost(post);

		Assertions.assertNotEquals(0, result.getPostId());
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void updatePostTest() {
		List<Post> posts = postServ.findAllPosts();
		Post updateMe = posts.get(posts.size() - 1);
		updateMe.setPostContent("Updated Content");
		Post result = postServ.savePost(updateMe);

		Assertions.assertEquals("Updated Content", result.getPostContent());
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findPostByPostIdTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getPostId());
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void findPostByUserIdTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getUsersId());
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void findPostByDateTest() {
		Post result = new Post(1, "content", 1, new Date(0), "testUrl", 1, "post");

		Assertions.assertNotEquals(0, result.getPostDate());
	}

	@Test
	@Order(6)
	@Rollback(value = false)
	public void deletePostTest() {
		List<Post> posts = postServ.findAllPosts();
		Post deleteMe = posts.get(posts.size() - 1);
		postServ.deletePost(deleteMe.getPostId());

		Assertions.assertEquals(Optional.empty(), postServ.findByPostId(deleteMe.getPostId()));
	}

	@Test
	@Order(7)

	public void findAllPostsTest() {
		Post test = new Post();
		List<Post> posts = postServ.findAllPosts();
		Assertions.assertNotEquals(0, posts.size());
	}

//	@Test
//	@Order(7)
//	@Rollback(value = false)
//	public void likePostTest() {
//		List<Post> posts = postServ.findAllPosts();
//		Post likeMe = posts.get(posts.size()-1);
//		
//		// int likeCount +1
//		boolean result = postServ.likePost(likeMe);
//
//		Assertions.assertEquals(true, result);
//	}
//	
//	@Test
//	@Order(8)
//	@Rollback(value = false)
//	public void dislikePostTest() {
//		List<Post> posts = postServ.findAllPosts();
//		Post dislikeMe = posts.get(posts.size()-1);
//		
//		// int likeCount -1
//		boolean result = postServ.dislikePost(dislikeMe);
//
//		Assertions.assertEquals(true, result);
//		
//	}

	// NEGATIVE TESTS HANDLED IN FRONT END CODE
}

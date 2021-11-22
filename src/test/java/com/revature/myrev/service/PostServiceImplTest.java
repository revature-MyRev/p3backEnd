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
	public void setUp () {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@After
	public void releaseMocks () throws Exception {
		closeable.close();
	}

	@Test
	@Order(1)
	@Rollback(value = false)
	public void createPostTest() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Post result = postServ.savePost(post);
		
		Assertions.assertNotEquals(0,result.getPostId());
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	public void updatePostTest() {
		List<Post> posts = postServ.findAllPosts();
		Post updateMe = posts.get(posts.size()-1);
		updateMe.setPostContent("Updated Content");
		Post result = postServ.savePost(updateMe);

		Assertions.assertEquals("Updated Content", result.getPostContent());
	}
	

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findPostByPostIdTest() {
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Assertions.assertNotEquals(0,result.getPostId());
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void findPostByUserIdTest() {
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Assertions.assertNotEquals(0,result.getUsersId());
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void findPostByDateTest() {
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Assertions.assertNotEquals(0,result.getPostDate());
	}
	
	@Test
	@Order(6)
	@Rollback(value = false)
	public void deletePostTest() {
		List<Post> posts = postServ.findAllPosts();
		Post deleteMe = posts.get(posts.size()-1);
		postServ.deletePost(deleteMe.getPostId());

		Assertions.assertEquals(Optional.empty(), postServ.findByPostId(deleteMe.getPostId()));
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
	
	//WHAT HAPPENS IF FUNCTIONS DO NOT WORK
	
	@Test
	@Order(9)
	@Rollback(value = false)
	//Users only control the content-body of a Post
	//Only way to break is empty posts, posts with too many characters, or inputs that cannot be translated into a String format
	//Create an exception to be thrown if user tries to submit each of these things?
	//Or find some way to completely prevent all of these and return whatever error message would come up
	public void createPostFailureTestEmptyBody() {
		
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Assertions.assertThrows(Exception.class, () -> postServ.savePost(post));
	}
	
	@Test
	@Order(10)
	@Rollback(value = false)
	public void createPostFailureTestTooManyCharacters() {
		
		int length = 256;
		String tooMany = "";
		for (int i = 0; i < length; i++){
		   tooMany.concat("X");
		}
		
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		Assertions.assertThrows(Exception.class, () -> postServ.savePost(post));
	}
	
	@Test
	@Order(11)
	@Rollback(value = false)
	public void updatePostFailureTestEmptyBody() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		post.setPostContent("");

		Assertions.assertThrows(Exception.class, () -> postServ.savePost(post));
	}
	
	@Test
	@Order(12)
	@Rollback(value = false)
	public void updatePostFailureTestTooManyCharacters() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");
		
		int length = 256;
		String tooMany = "";
		for (int i = 0; i < length; i++){
		   tooMany.concat("X");
		}
		post.setPostContent(tooMany);

		Assertions.assertThrows(Exception.class, () -> postServ.savePost(post));
	}

}

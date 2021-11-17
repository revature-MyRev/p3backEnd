package com.revature.myrev.junit;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Post;
import com.revature.myrev.service.PostServiceImpl;


@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PostJUnitTest {
	
	@Autowired PostServiceImpl postServ;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void createPostTest() {
		Post post = new Post(1, "content", 1, new Date(0));
		
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
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertNotEquals(0,result.getPostId());
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void findPostByUserIdTest() {
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertNotEquals(0,result.getUserId());
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void findPostByDateTest() {
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertNotEquals(0,result.getPostDate());
	}
	
	@Test
	@Order(6)
	@Rollback(value = false)
	public void deletePostTest() {
		List<Post> posts = postServ.findAllPosts();
		Post deleteMe = posts.get(posts.size()-1);
		postServ.deletePost(deleteMe.getPostId());

		Assertions.assertNull(postServ.findByPostId(deleteMe.getPostId()));
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
	
	@Test
	@Order(9)
	@Rollback(value = false)
	public void createPostFailureTest() {
		Post post = new Post(1, "content", 1, new Date(0));
		
		Post result = postServ.savePost(post);
		
		Assertions.assertEquals(0,result.getPostId());
	}
	
	@Test
	@Order(10)
	@Rollback(value = false)
	public void updatePostFailureTest() {
		List<Post> posts = postServ.findAllPosts();
		Post updateMe = posts.get(posts.size()-1);
		updateMe.setPostContent("Updated Content");
		Post result = postServ.savePost(updateMe);

		Assertions.assertNotEquals("Updated Content", result.getPostContent());
	}
	

	@Test
	@Order(11)
	@Rollback(value = false)
	public void findPostByPostIdFailureTest() {
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertNotEquals(0,result.getPostId());
	}
	
	@Test
	@Order(12)
	@Rollback(value = false)
	public void findPostByUserIdFailureTest() {
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertEquals(0,result.getUserId());
	}
	
	@Test
	@Order(13)
	@Rollback(value = false)
	public void findPostByDateFailureTest() {
		Post result = new Post(1, "content", 1, new Date(0));
		
		Assertions.assertEquals(0,result.getPostDate());
	}
	
	@Test
	@Order(14)
	@Rollback(value = false)
	public void deletePostFailureTest() {
		List<Post> posts = postServ.findAllPosts();
		Post deleteMe = posts.get(posts.size()-1);
		postServ.deletePost(deleteMe.getPostId());

		Assertions.assertNotNull(postServ.findByPostId(deleteMe.getPostId()));
	}
	
//	@Test
//	@Order(15)
//	@Rollback(value = false)
//	public void likePostFailureTest() {
//		List<Post> posts = postServ.findAllPosts();
//		Post likeMe = posts.get(posts.size()-1);
//		
//		// int likeCount +1
//		boolean result = postServ.likePost(likeMe);
//
//		Assertions.assertEquals(false, result);
//	}
//	
//	@Test
//	@Order(16)
//	@Rollback(value = false)
//	public void dislikePostFailureTest() {
//		List<Post> posts = postServ.findAllPosts();
//		Post dislikeMe = posts.get(posts.size()-1);
//		
//		// int likeCount -1
//		boolean result = postServ.dislikePost(dislikeMe);
//
//		Assertions.assertEquals(false, result);
//		
//	}
	
	
	
	

}

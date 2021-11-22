package com.revature.myrev.repository;


import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.revature.myrev.MyRevApplication;
//=======
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.revature.myrev.MyRevApplication;
import com.revature.myrev.model.Post;


@SpringBootTest
@ContextConfiguration(classes = MyRevApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Rollback(false)
@DataJpaTest
class PostRepositoryTest {

	// Not mocking anything here. 




// Not mocking anything here.

	// Be sure to delete any additions made to db tables at the end of each test
	/** PostRepository for testing */
	@Autowired
	private PostRepository repository;

	
	@Test
	void test() {
		fail("Not yet implemented");
		}


	@Test
	@Order(1)
	public void createPostTest() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

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
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		Assertions.assertNotEquals(0, result.getPostId());
	}

	@Test
	@Order(4)

	public void findPostByUserIdTest() {
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		Assertions.assertNotEquals(0, result.getUsersId());
	}

	@Test
	@Order(5)

	public void findPostByDateTest() {
		Post result = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

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

	@Test
	@Order(9)
	public void createPostFailureTestEmptyBody() {

		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		Assertions.assertThrows(Exception.class, () -> repository.save(post));
	}

	@Test
	@Order(10)

	public void createPostFailureTestTooManyCharacters() {

		int length = 256;
		String tooMany = "";
		for (int i = 0; i < length; i++) {
			tooMany.concat("X");
		}

		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		Assertions.assertThrows(Exception.class, () -> repository.save(post));
	}

	@Test
	@Order(11)

	public void updatePostFailureTestEmptyBody() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		post.setPostContent("");

		Assertions.assertThrows(Exception.class, () -> repository.save(post));
	}

	@Test
	@Order(12)

	public void updatePostFailureTestTooManyCharacters() {
		Post post = new Post(1, "content", 1, new Date(0),1,"testUrl","post");

		int length = 256;
		String tooMany = "";
		for (int i = 0; i < length; i++) {
			tooMany.concat("X");
		}
		post.setPostContent(tooMany);

		Assertions.assertThrows(Exception.class, () -> repository.save(post));

	}

}

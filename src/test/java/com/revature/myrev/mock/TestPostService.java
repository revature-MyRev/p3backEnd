package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;
import com.revature.myrev.service.PostServiceImpl;

public class TestPostService {
	/*
	 * @InjectMocks PostServiceImpl postService;
	 * 
	 * @Mock PostRepository postRepository;
	 * 
	 * @Test
	 * 
	 * public void testMock() { PostRepository mockObj =
	 * Mockito.mock(PostRepository.class);
	 * 
	 * List<Post> posts = postRepository.findAll();
	 * Mockito.when(mockObj.findAll()).thenReturn(posts);
	 * 
	 * List<Post> thread = mockObj.findAll();
	 * 
	 * // Assert. assertEquals(posts, thread); Mockito.verify(mockObj).findAll();
	 * 
	 * }
	 * 
	 * 
	 * @Test public void testMock2() { PostRepository mockObj =
	 * Mockito.mock(PostRepository.class); List<Post> posts =
	 * postRepository.findByUserId(1);
	 * Mockito.when(mockObj.findByUserId(1)).thenReturn(posts);
	 * 
	 * List<Post> mockPosts = mockObj.findByUserId(1);
	 * 
	 * assertEquals(posts, mockPosts); Mockito.verify(mockObj).findByUserId(1); }
	 * 
	 * 
	 * @InjectMocks PostServiceImpl postService;
	 * 
	 * @Mock PostRepository postRepository;
	 * 
	 * Post post;
	 * 
	 * @BeforeEach void setUp() throws Exception{
	 * MockitoAnnotations.initMocks(this); post = new Post();
	 * 
	 * post.setPostId(6); post.setUserId(1);
	 * post.setPostContent("This is a sample post"); }
	 * 
	 * @Test final void testGetPost() {
	 * when(postRepository.findAll()).thenReturn(Collections.singletonList(post));
	 * // when(postRepository.findByPostId(anyInt())).thenReturn(post);
	 * assertNotNull(post); assertEquals(6, post.getPostId()); }
	 * 
	 * 
	 * 
	 * 
	 * @Before public void init() { MockitoAnnotations.initMocks(this); }
	 * 
	 * @Test public void getAllPostsTest() throws ParseException {
	 * 
	 * long millis = System.currentTimeMillis();
	 * 
	 * // creating sql date object java.sql.Date sqlDate = new
	 * java.sql.Date(millis);
	 * 
	 * 
	 * // String sDate1="31/12/1998"; // Date date1 = (Date) new
	 * SimpleDateFormat("dd/MM/yyyy").parse(sDate1); List<Post> list = new
	 * ArrayList<Post>(); Post postOne = new Post(1, "This is a sample post", 2,
	 * sqlDate); Post postTwo = new Post(2, "This is another post", 2, sqlDate);
	 * Post postThree = new Post(3, "Thid is a third post", 3, sqlDate);
	 * 
	 * list.add(postOne); list.add(postTwo); list.add(postThree);
	 * 
	 * when(postRepository.findByUserId(anyInt())).thenReturn(list);
	 * 
	 * //test List<Post> postList = postRepository.findByUserId(0);
	 * 
	 * assertEquals(3, postList.size()); // verify(postRepository,
	 * times(1)).getPostList(); }
	 * 
	 * @Test public void getPostByIdTest() {
	 * 
	 * long millis = System.currentTimeMillis();
	 * 
	 * // creating sql date object java.sql.Date sqlDate = new
	 * java.sql.Date(millis); List<Post> posts = postRepository.findByUserId(1);
	 * 
	 * // when(postRepository.findByUserId(1)).thenReturn(new Post(1,"Lokesh",2,
	 * sqlDate));
	 * when(postRepository.findAll()).thenReturn(Collections.singletonList(posts));
	 * 
	 * assertEquals("Lokesh", post.getFirstName()); assertEquals("Gupta",
	 * post.getLastName()); assertEquals("user@email.com", post.getEmail()); }
	 * 
	 * @Test public void createPostTest() { PostVO post = new
	 * PostVO(1,"Lokesh","Gupta","user@email.com");
	 * 
	 * manager.addPost(post);
	 * 
	 * verify(dao, times(1)).addPost(post); }
	 */

	private PostRepository postRepository;
//	private PostServiceImpl postService;

	@BeforeEach
	void initService() {
		postRepository = mock(PostRepository.class);
		// postService = new PostServiceImpl();

	}

	@Test
	void create() {
		Post post = new Post();

		post = new Post();

		post.setPostId(6);
		post.setUsersId(1);
		post.setPostContent("This is a sample post");

		when(postRepository.save(any(Post.class))).thenReturn(post);
		assertNotNull(post);
		assertEquals(6, post.getPostId());

	}

}

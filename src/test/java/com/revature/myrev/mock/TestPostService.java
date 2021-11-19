package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.model.Post;
import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;
import com.revature.myrev.repository.PostRepository;
import com.revature.myrev.service.PostServiceImpl;

public class TestPostService {
	/*
	 * @Test
	 
    public void testMock() {
    PostRepository mockObj = Mockito.mock(PostRepository.class);
    List<Post> post = postRepository.findAll();
    Mockito.when(mockObj.findAllByThreadId(1)).thenReturn(post);

    List<Post> thread = mockObj.findAllByThreadId(1);

   // Assert.
    assertEquals(post, thread);
    Mockito.verify(mockObj).findAllByThreadId(1); 
	
	}
	
	
	public void testMock2() {
		PostRepository mockObj = Mockito.mock(PostRepository.class);
		List<Post> posts = postRepository.findByPostId();
		Mockito.when(mockObj.findByPostId(1))thenReturn(posts);
		
		List<Post> mockPosts = mockObj.findByPostId(1);
		
		assertEquals(posts, mockPosts);
		Mockito.verify(mockObj).findByPostId(1);
	}
	

	@InjectMocks
	 PostServiceImpl postService;
	
	@Mock
	PostRepository postRepository;
	
	Post post;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		post = new Post();
		
		post.setPostId(6);
		post.setUserId(1);
		post.setPostContent("This is a sample post");
	}
	
	@Test
	final void testGetPost() {
		when(postRepository.findByPostId(anyInt())).thenReturn(post);
		assertNotNull(post);
		assertEquals(6, post.getPostId());
	}		
	*/
}

package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;

public class TestPostRepository {
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
		List<Post> posts = postRepository.findByUserId();
		Mockito.when(mockObj.findByUserId(1))thenReturn(posts);
		
		List<Post> mockPosts = mockObj.findByUserId(1);
		
		assertEquals(posts, mockPosts);
		Mockito.verify(mockObj).findByUserId(1);
	}
	*/
	
}

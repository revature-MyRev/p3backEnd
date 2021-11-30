package com.revature.myrev.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.myrev.controller.PostController;
import com.revature.myrev.model.Post;
import com.revature.myrev.service.PostServiceImpl;

public class TestPostController {

	@InjectMocks
	PostController postController;

	@Mock
	PostServiceImpl postService;

	Post post;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		post = new Post();

		post.setPostId(6);
		post.setUsersId(1);
		post.setPostContent("This is a sample post");

	}

	@Test
	final void testGetPost() {
		// when(postService.findByPostId(anyInt())).thenReturn(post);
		when(postService.findAllPosts()).thenReturn(Collections.singletonList(post));

		assertNotNull(post);
		assertEquals(6, post.getPostId());
	}

}

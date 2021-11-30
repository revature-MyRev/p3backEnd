package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import com.revature.myrev.model.Post;

public interface PostService {

	public List<Post> findAllPosts();

	public Optional<Post> findByPostId(int id);

	public List<Post> findByUserId(int uid);

	public Post savePost(Post post);

	public Post updatePost(int id, Post post);

	public void deletePost(int id);
}

package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository repository;

	@Override
	public List<Post> findAllPosts() {
		return repository.findAll();
	}

	@Override
	public Optional<Post> findByPostId(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Post> findByUserId(int uid) {
		return repository.findByUsersId(uid);
	}

	@Override
	public Post savePost(Post post) {
		return repository.save(post);
	}

	@Override
	public Post updatePost(int id, Post post) {
		return repository.save(post);
	}

	@Override
	public void deletePost(int id) {
		repository.deleteById(id);
	}

}

package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.myrev.model.Post;
import com.revature.myrev.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	public List<Post> findAllPosts() {
		return repository.findAll();
	}

	public Optional<Post> findByPostId(int id) {
		return repository.findById(id);
	}
	
	public List<Post> findByUserId(int uid) {
		return repository.findByUserId(uid);
	}

    public Post savePost(Post post) {
    	return repository.save(post);
    }
    
    public Post updatePost(int id, Post post) {
    	return repository.save(post);
    }

    public void deletePost(int id) {
    	repository.deleteById(id);
    }
	
}

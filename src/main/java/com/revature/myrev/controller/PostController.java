package com.revature.myrev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.model.Post;
import com.revature.myrev.service.PostServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostServiceImpl service;

	@GetMapping("/posts")
	public List<Post> findAllPosts() {
		return service.findAllPosts();
	}

	@GetMapping("/postById/{post_id}")
	public Optional<Post> findByPostId(@PathVariable int post_id) {
		return service.findByPostId(post_id);
	}

	@GetMapping("/postByUserId/{user_id}")
	public List<Post> findByUserId(@PathVariable int user_id) {
		return service.findByUserId(user_id);
	}

	@PostMapping("/posts")
	public void save(@RequestBody Post post) {
		service.savePost(post);
	}

	@PutMapping("/posts/{post_id}")
	public void update(@PathVariable int post_id, @RequestBody Post post) {
		service.savePost(post);
	}

	@DeleteMapping("/posts/{post_id}")
	public void delete(@PathVariable int post_id) {
		service.deletePost(post_id);
	}
}

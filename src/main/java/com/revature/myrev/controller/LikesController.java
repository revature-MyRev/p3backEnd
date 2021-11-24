package com.revature.myrev.controller;

import java.util.List;

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

import com.revature.myrev.model.Likes;
import com.revature.myrev.service.LikesServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LikesController {
	
	@Autowired
	private LikesServiceImpl service;
	
	@GetMapping("/likes")
	public List<Likes> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/likesByLid/{like_id}")
	public List<Likes> findByLikeId(@PathVariable int like_id) {
		return service.findByLikeId(like_id);
	}
	
	@GetMapping("/likesByPid/{post_id}")
	public List<Likes> findByPostId(@PathVariable int post_id) {
		return service.findByPostId(post_id);
	}
	
	@GetMapping("/likesByUid/{users_id}")
	public List<Likes> findByUsersId(@PathVariable int users_id) {
		return service.findByUsersId(users_id);
	}
	
	@PostMapping("/likes")
	public void saveLike(@RequestBody Likes like) {
		service.saveLike(like);
	}
	
	@PutMapping("/likes/{like_id}")
	public void updateLike(@PathVariable int like_id, @RequestBody Likes like) {
		like.setLikeId(like_id);
		service.saveLike(like);
	}
	
	@DeleteMapping("/likes/{like_id}")
	public void deleteLike(@PathVariable int like_id) {
		service.deleteLike(like_id);
	}

}

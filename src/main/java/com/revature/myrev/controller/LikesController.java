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
	
	@GetMapping("/likesByLid/{likeId}")
	public List<Likes> findByLikeId(@PathVariable int likeId) {
		return service.findByLikeId(likeId);
	}
	
	@GetMapping("/likesByPid/{postId}")
	public List<Likes> findByPostId(@PathVariable int postId) {
		return service.findByPostId(postId);
	}
	
	@GetMapping("/likesByUid/{usersId}")
	public List<Likes> findByUsersId(@PathVariable int usersId) {
		return service.findByUsersId(usersId);
	}
	
	@PostMapping("/likes")
	public void saveLike(@RequestBody Likes like) {
		service.saveLike(like);
	}
	
	@PutMapping("/likes/{like_id}")
	public void updateLike(@PathVariable int likeId, @RequestBody Likes like) {
		like.setLikeId(likeId);
		service.saveLike(like);
	}
	
	@DeleteMapping("/likes/{likeId}")
	public void deleteLike(@PathVariable int likeId) {
		service.deleteLike(likeId);
	}
}
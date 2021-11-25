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

import com.revature.myrev.model.Dislikes;
import com.revature.myrev.service.DislikesServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DislikesController {
	
	@Autowired
	private DislikesServiceImpl service;
	
	@GetMapping("/dislikes")
	public List<Dislikes> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/dislikesByDid/{dislikeId}")
	public List<Dislikes> findByLikeId(@PathVariable int dislikeId) {
		return service.findByDislikeId(dislikeId);
	}
	
	@GetMapping("/dislikesByPid/{postId}")
	public List<Dislikes> findByPostId(@PathVariable int postId) {
		return service.findByPostId(postId);
	}
	
	@GetMapping("/dislikesByUid/{usersId}")
	public List<Dislikes> findByUsersId(@PathVariable int usersId) {
		return service.findByUsersId(usersId);
	}
	
	@PostMapping("/dislikes")
	public void saveLike(@RequestBody Dislikes dislike) {
		service.saveDislike(dislike);
	}
	
	@PutMapping("/dislikes/{dislikeId}")
	public void updateDislike(@PathVariable int dislikeId, @RequestBody Dislikes dislike) {
		dislike.setDislikeId(dislikeId);
		service.saveDislike(dislike);
	}
	
	@DeleteMapping("/dislikes/{dislikeId}")
	public void deleteDislike(@PathVariable int dislikeId) {
		service.deleteDislike(dislikeId);
	}
}
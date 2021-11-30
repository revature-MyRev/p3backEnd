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
	
	@GetMapping("/dislikesByDid/{dislike_id}")
	public List<Dislikes> findByLikeId(@PathVariable int dislike_id) {
		return service.findByDislikeId(dislike_id);
	}
	
	@GetMapping("/dislikesByPid/{post_id}")
	public List<Dislikes> findByPostId(@PathVariable int post_id) {
		return service.findByPostId(post_id);
	}
	
	@GetMapping("/dislikesByUid/{users_id}")
	public List<Dislikes> findByUsersId(@PathVariable int users_id) {
		return service.findByUsersId(users_id);
	}
	
	@PostMapping("/dislikes")
	public void saveLike(@RequestBody Dislikes dislike) {
		service.saveDislike(dislike);
	}
	
	@PutMapping("/dislikes/{dislike_id}")
	public void updateDislike(@PathVariable int dislike_id, @RequestBody Dislikes dislike) {
		dislike.setDislikeId(dislike_id);
		service.saveDislike(dislike);
	}
	
	@DeleteMapping("/dislikes/{dislike_id}")
	public void deleteDislike(@PathVariable int dislike_id) {
		service.deleteDislike(dislike_id);
	}


}

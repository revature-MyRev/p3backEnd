package com.revature.myrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.model.Follower;
import com.revature.myrev.service.FollowerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/followers")
public class FollowerController {
	
	@Autowired
	private FollowerService followerService;
	
	
	@GetMapping("/findFollowers/{followedId}")
	public Follower findByFollowedId(@PathVariable int followedId) {
		// TODO Auto-generated method stub
		return followerService.findByFollowedId(followedId);
	}

	@GetMapping("/followers")
	public List<Follower> findAll() {
		// TODO Auto-generated method stub
		return followerService.findAll();
	}

	@GetMapping("/findById/{id}")
	public Follower findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return followerService.findById(id);
	}

	@PostMapping("/followers")
	public void save(Follower follower) {
		followerService.save(follower);
		
	}

	@PutMapping("/followers/{id}")
	public void update(@PathVariable int id, Follower follower) {
		followerService.save(follower);
		
	}

	@DeleteMapping("/followers/{id}")
	public void delete(@PathVariable int id) {
		followerService.deleteById(id);
		
	}
	

}

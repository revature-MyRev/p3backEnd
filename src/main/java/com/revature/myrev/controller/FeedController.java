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

import com.revature.myrev.model.Feed;
import com.revature.myrev.service.FeedServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FeedController {

	@Autowired
	private FeedServiceImpl service;

	@GetMapping("/feeds")
	public List<Feed> findAll() {
		return service.findAll();
	}

	@GetMapping("/feeds/{feed_id}")
	public Feed findById(@PathVariable int feedId) {
		return service.findById(feedId);
	}

	@PostMapping("/feeds")
	public int save(@RequestBody Feed feed) {
		service.save(feed);
		return feed.getFeedId();
	}

	@PutMapping("/feeds/{feed_id}")
	public void update(@PathVariable int feedId, @RequestBody Feed feed) {
		service.save(feed);
	}

	@DeleteMapping("/feeds/{feed_id}")
	public void delete(@PathVariable int feedId) {
		service.deleteById(feedId);
	}
}
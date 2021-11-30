package com.revature.myrev.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.revature.myrev.model.Follower;


public interface FollowerService {

	public List<Follower> findByFollowedId(int followedId);
	
	public Follower findByFollowedIdAndFollowerId(int followedId , int followerId);
	
	public List<Follower> findAll();

	public Follower findById(int id);

	public void save(Follower follower);

	public void update(int id, Follower follower);

	public void deleteById(int id);
	
}

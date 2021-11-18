package com.revature.myrev.service;

import java.util.List;
import com.revature.myrev.model.Follower;


public interface FollowerService {

	public Follower findByFollowedId(int followedId);
	
	public List<Follower> findAll();

	public Follower findById(int id);

	public void save(Follower follower);

	public void update(int id, Follower follower);

	public void deleteById(int id);
	
}

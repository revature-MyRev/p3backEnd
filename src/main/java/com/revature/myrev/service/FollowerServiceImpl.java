package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Follower;
import com.revature.myrev.repository.FollowerRepository;

@Service
public class FollowerServiceImpl implements FollowerService{

	@Autowired
	public FollowerRepository followerRepository;
	
	@Override
	public List<Follower> findByFollowedId(int followedId) {
		// TODO Auto-generated method stub
		return followerRepository.findByFollowedId(followedId);
	}

	@Override
	public List<Follower> findAll() {
		// TODO Auto-generated method stub
		return followerRepository.findAll();
	}

	@Override
	public Follower findById(int id) {
		// TODO Auto-generated method stub
		return followerRepository.findById(id).get();
	}

	@Override
	public void save(Follower follower) {
		followerRepository.save(follower);
		
	}

	@Override
	public void update(int id, Follower follower) {
		followerRepository.save(follower);
		
	}

	@Override
	public void deleteById(int id) {
		followerRepository.deleteById(id);
		
	}

	@Override
	public Follower findByFollowedIdAndFollowerId(int followedId, int followerId) {
		// TODO Auto-generated method stub
		return followerRepository.findByFollowedIdAndFollowerId(followedId, followerId);
	}


	

}

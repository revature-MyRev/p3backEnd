package com.revature.myrev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Follower;


@Repository
public interface FollowerRepository extends JpaRepository<Follower, Integer> {
	
	public List<Follower> findByFollowedId(int followedId);
	
	public Follower findByFollowedIdAndFollowerId(int followedId , int followerId);

}

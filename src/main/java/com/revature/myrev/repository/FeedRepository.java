package com.revature.myrev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

	public Feed findById(int id);

}
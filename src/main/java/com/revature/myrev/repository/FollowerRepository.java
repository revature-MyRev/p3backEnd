package com.revature.myrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Follower;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Integer> {

}

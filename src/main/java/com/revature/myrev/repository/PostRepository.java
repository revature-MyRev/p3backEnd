package com.revature.myrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}

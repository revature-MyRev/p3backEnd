package com.revature.myrev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer>{
	
	public List<Likes> findByUsersId(int uid);
	
	public List<Likes> findByLikeId(int lid);
	
	public List<Likes> findByPostId(int pid);
	
}

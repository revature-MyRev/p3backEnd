package com.revature.myrev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Dislikes;

@Repository
public interface DislikesRepository extends JpaRepository<Dislikes, Integer>{
	
	public List<Dislikes> findByUsersId(int uid);
	
	public List<Dislikes> findByDislikeId(int did);
	
	public List<Dislikes> findByPostId(int pid);
	
}

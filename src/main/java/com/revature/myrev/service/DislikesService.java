package com.revature.myrev.service;

import java.util.List;

import com.revature.myrev.model.Dislikes;

public interface DislikesService {

	public List<Dislikes> findAll();
	
	public List<Dislikes> findByDislikeId(int lid);
	
	public List<Dislikes> findByPostId(int pid);
	
	public List<Dislikes> findByUsersId(int uid);
	
	public Dislikes saveDislike(Dislikes dislike);
	
	public Dislikes updateDislike(int id, Dislikes dislike);
	
	public void deleteDislike(int id);
}

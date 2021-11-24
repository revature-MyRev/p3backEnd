package com.revature.myrev.service;

import java.util.List;

import com.revature.myrev.model.Likes;

public interface LikesService {
	
	public List<Likes> findAll();
	
	public List<Likes> findByLikeId(int lid);
	
	public List<Likes> findByPostId(int pid);
	
	public List<Likes> findByUsersId(int uid);
	
	public Likes saveLike(Likes like);
	
	public Likes updateLike(int id, Likes like);
	
	public void deleteLike(int id);
	
	

}

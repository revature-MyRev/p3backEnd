package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Likes;
import com.revature.myrev.repository.LikesRepository;

@Service
public class LikesServiceImpl implements LikesService {
	
	@Autowired
	LikesRepository repository;

	@Override
	public List<Likes> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Likes> findByLikeId(int lid) {
		return repository.findByLikeId(lid);
	}

	@Override
	public List<Likes> findByPostId(int pid) {
		return repository.findByPostId(pid);
	}

	@Override
	public List<Likes> findByUsersId(int uid) {
		return repository.findByUsersId(uid);
	}

	@Override
	public Likes saveLike(Likes like) {
		return repository.save(like);
	}

	@Override
	public Likes updateLike(int id, Likes like) {
		return repository.save(like);
	}

	@Override
	public void deleteLike(int id) {
		repository.deleteById(id);

	}

}

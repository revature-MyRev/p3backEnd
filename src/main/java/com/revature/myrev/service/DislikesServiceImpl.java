package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Dislikes;
import com.revature.myrev.repository.DislikesRepository;

@Service
public class DislikesServiceImpl implements DislikesService {
	
	@Autowired
	DislikesRepository repository;

	@Override
	public List<Dislikes> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Dislikes> findByDislikeId(int lid) {
		return repository.findByDislikeId(lid);
	}

	@Override
	public List<Dislikes> findByPostId(int pid) {
		return repository.findByPostId(pid);
	}

	@Override
	public List<Dislikes> findByUsersId(int uid) {
		return repository.findByUsersId(uid);
	}

	@Override
	public Dislikes updateDislike(int id, Dislikes dislike) {
		return repository.save(dislike);
	}

	@Override
	public void deleteDislike(int id) {
		repository.deleteById(id);
	}

	@Override
	public Dislikes saveDislike(Dislikes dislike) {
		return repository.save(dislike);
	}

}

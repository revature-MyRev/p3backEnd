package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(int userId) {
		return repository.findById(userId).get();
	}

	public void save(User user) {
		repository.save(user);
	}
	
}

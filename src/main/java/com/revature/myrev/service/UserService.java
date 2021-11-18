package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;

public interface UserService {

    public User findByUsername(String username);
@Service
public class UserService {

	public List<User> findAll();
	@Autowired
	UserRepository repository;

	public User findById(int id);
	public List<User> findAll() {
		return repository.findAll();
	}

	public void save(User user);
	public User findById(int userId) {
		return repository.findById(userId).get();
	}

	public void update(int id, User user);

	public void deleteById(int id);
	public void save(User user) {
		repository.save(user);
	}

}

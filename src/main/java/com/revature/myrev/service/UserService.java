package com.revature.myrev.service;

import java.util.List;

import com.revature.myrev.model.User;

public interface UserService {
	
public User findByUsername(String username);
	
	public List<User> findAll();

	public User findById(int id);

	public void save(User user);

	public void update(int id, User user);

	public void deleteById(int id);

	
}

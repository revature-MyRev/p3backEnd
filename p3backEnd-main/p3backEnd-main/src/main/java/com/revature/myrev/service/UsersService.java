package com.revature.myrev.service;

import java.util.List;

import com.revature.myrev.model.Users;

public interface UsersService {
	
public Users findByUsername(String username);
	
	public List<Users> findAll();

	public Users findById(int id);

	public void save(Users user);

	public void update(int id, Users user);

	public void deleteById(int id);

	
}

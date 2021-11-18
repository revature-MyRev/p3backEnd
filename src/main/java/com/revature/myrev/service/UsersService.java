package com.revature.myrev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.myrev.model.Users;

@Service
public interface UsersService {
	
    public Users findByUsersname(String usersname);
	
	public List<Users> findAll();

	public Users findById(int id);

	public void save(Users users);

	public void update(int id, Users users);

	public void deleteById(int id);

}

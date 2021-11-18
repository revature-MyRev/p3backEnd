package com.revature.myrev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;

public interface UsersService {
	
    public Users findByUserName(String username);
	
	public List<Users> findAll();

	public Users findById(int id);

	public Users save(Users user);

	public void update(int id, Users user);

<<<<<<< HEAD
	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(int userId) {
		return repository.findById(userId).get();
	}

	public void save(User user) {
		repository.save(user);
	}
	
=======
	public void deleteById(int id);
>>>>>>> origin/main
}

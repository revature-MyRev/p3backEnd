package com.revature.myrev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

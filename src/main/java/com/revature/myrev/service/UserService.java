package com.revature.myrev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repository; // note this

}

package com.revature.myrev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository repository;

}

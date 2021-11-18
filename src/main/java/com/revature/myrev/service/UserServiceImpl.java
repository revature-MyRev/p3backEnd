package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepository;

	@Override
	public Users findByUserName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username);
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void save(Users user) {
		userRepository.save(user);

	}

	@Override
	public void update(int id, Users user) {
		userRepository.save(user);

	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}

package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public void update(int id, User user) {
		userRepository.save(user);

	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}

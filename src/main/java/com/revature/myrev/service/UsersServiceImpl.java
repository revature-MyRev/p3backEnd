package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	public UsersRepository userRepository;

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username);
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public Users save(Users user) {
		return userRepository.save(user);

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

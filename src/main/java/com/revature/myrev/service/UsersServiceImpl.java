package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	public UsersRepository usersRepository;

	@Override
	public Users findByUsersname(String usersname) {
		// TODO Auto-generated method stub
		return usersRepository.findByUsersname(usersname);
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id).get();
	}

	@Override
	public void save(Users users) {
		usersRepository.save(users);

	}

	@Override
	public void update(int id, Users users) {
		usersRepository.save(users);

	}

	@Override
	public void deleteById(int id) {
		usersRepository.deleteById(id);

	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

}

package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.myrev.exception.ObjectNotFoundException;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	public UsersRepository userRepository;

	/**
	 * Requests user from the repository that matches the given user name
	 * 
	 * @param username The user name associated with the user to be retrieved.
	 * @throws ObjectNotFoundException Throws an exception when a user associated with the given user name is not retrieved.
	 * @return The user associated with the given user name.
	 */
	@Override
	public Users findByUserName(String username) {
		Users user = userRepository.findByUserName(username);
		if (user == null) {
			throw new ObjectNotFoundException("User Record Not Found");
		} 
		return user;
	}

	@Override
	public Users findById(int id) {
		return userRepository.findById(id).get();
	}

	/**
	 * Sends a user object to userRepository to save in the database.
	 * 
	 * @param user The user object to be added to the database.
	 * @return The user object saved in the database with an updated user id.
	 */
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

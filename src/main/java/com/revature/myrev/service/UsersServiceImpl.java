package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.exception.ObjectNotFoundException;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	public UsersRepository repository;

	/**
	 * Requests user from the repository that matches the given user name
	 * 
	 * @param username The user name associated with the user to be retrieved.
	 * @throws ObjectNotFoundException Throws an exception when a user associated with the given user name is not retrieved.
	 * @return The user associated with the given user name.
	 */
	@Override
	public Users findByUsersname(String usersname) {
		Users users = repository.findByUsersname(usersname);
		if (users == null) {
			throw new ObjectNotFoundException("User Record Not Found");
		} 
		return users;
	}

	@Override
	public Users findById(int id) {
		return repository.findById(id).get();
	}

	/**
	 * Sends a user object to userRepository to save in the database.
	 * 
	 * @param user The user object to be added to the database.
	 * @return The user object saved in the database with an updated user id.
	 */
	@Override
	public Users save(Users users) {
		return repository.save(users);

	}

	@Override
	public void update(int id, Users users) {
		repository.save(users);

	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);

	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
  }
}

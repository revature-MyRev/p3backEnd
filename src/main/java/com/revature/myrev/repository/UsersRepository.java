package com.revature.myrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.exception.ObjectNotFoundException;
import com.revature.myrev.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	/**
	 * Requests user from the database that matches the given user name
	 * 
	 * @param userName The user name associated with the user to be retrieved.
	 * @return The user associated with the given user name.
	 */
	Users findByUserName(String userName);

}

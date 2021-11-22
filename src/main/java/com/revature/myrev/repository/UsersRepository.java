package com.revature.myrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByUsersname(String usersname);

	

}

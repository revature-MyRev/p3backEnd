package com.revature.myrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.myrev.model.Users;
import com.revature.myrev.service.UsersServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@EnableSwagger2
public class UsersController {

	@Autowired
	private UsersServiceImpl service;

	/**
	 * Requests user from service that matches the given user name
	 * 
	 * @param username The user name associated with the user to be retrieved.
	 * @return The user associated with the given user name.
	 */
	@GetMapping(path = "/findByUsername/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users findByUsersname(@PathVariable String usersname) {
		return service.findByUsersname(usersname);
	}
	
	/**
	 * Sends a user object to service to save in the database
	 * 
	 * @param user The user object to be added to the database.
	 * @return The user object saved in the database with an updated user id.
	 */
    @PostMapping(path = "/addUser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Users save(@RequestBody Users users) {
    	return service.save(users);
    }
    
    @GetMapping("/findById/{id}")
	public Users findById(@PathVariable int id) {
		return service.findById(id);
	}

	@PutMapping("/users/{id}")
	public void update(@PathVariable int id, Users users) {
		service.save(users);

	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		service.deleteById(id);

	}

	@GetMapping("/users")
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}
}

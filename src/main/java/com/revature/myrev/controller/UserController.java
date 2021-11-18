package com.revature.myrev.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.revature.myrev.service.UserService;
import com.revature.myrev.service.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl serviceImpl;

	@GetMapping("/users")
	public List<Users> getUsers(){
		return serviceImpl.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) {
		return serviceImpl.findById(id);
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody Users user) {
		serviceImpl.save(user);
	}
	
	@PutMapping("/editProfile/{id}")
	public void editUser(@PathVariable(value ="id") int id, @RequestBody Users user) {
		user.setUserId(id);
		serviceImpl.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id){
		serviceImpl.deleteById(id);
	}

	
}

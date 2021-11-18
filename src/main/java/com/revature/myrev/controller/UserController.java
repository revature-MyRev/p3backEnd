package com.revature.myrev.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.myrev.model.User;
import com.revature.myrev.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> getUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody User user) {
		service.save(user);
	}

	
	@PutMapping("/editProfile/{id}")
	public void editUser(@PathVariable(value ="id") int id, @RequestBody User user) {
		user.setUserId(id);
		service.save(user);
	}
	
	
	
}

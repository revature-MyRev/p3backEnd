package com.revature.myrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.UserService;
import com.revature.myrev.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/findByUsername/{username}")
	public User findFollowersByUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return userService.findByUsername(username);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	@PostMapping("/users")
	public void save(User user) {
		userService.save(user);

	}

	@PutMapping("/users/{id}")
	public void update(@PathVariable int id, User user) {
		userService.save(user);

	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userService.deleteById(id);

	}

	@GetMapping("/users")
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

}

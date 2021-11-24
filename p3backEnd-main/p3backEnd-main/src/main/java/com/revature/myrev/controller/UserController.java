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

import com.revature.myrev.service.UsersService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.revature.myrev.model.Users;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@EnableSwagger2
public class UserController {
	
	@Autowired
	private UsersService userService;
	
	@GetMapping("/findByUsername/{username}")
	public Users findFollowersByUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return userService.findByUsername(username);
	}

	@GetMapping("/findById/{id}")
	public Users findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	@PostMapping("/users")
	public void save(Users user) {
		userService.save(user);

	}

	@PutMapping("/users/{id}")
	public void update(@PathVariable int id, Users user) {
		userService.save(user);

	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userService.deleteById(id);

	}

	@GetMapping("/users")
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}

}

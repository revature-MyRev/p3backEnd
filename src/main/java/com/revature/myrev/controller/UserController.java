package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(path = "/findByUserName/{userName}")
	public User findByUserName(@PathVariable String userName) {
		return service.findByUserName(userName);
	}
	
    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody User user) {
    	return service.addUser(user);
    }
}

package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.model.Users;
import com.revature.myrev.service.UsersService;
import com.revature.myrev.service.UsersServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersServiceImpl service;
	
	@GetMapping(path = "/findByUserName/{userName}")
	public Users findByUserName(@PathVariable String userName) {
		return service.findByUserName(userName);
	}
	
    @PostMapping(path = "/addUser")
    public Users addUser(@RequestBody Users user) {
    	return service.save(user);
    }

}

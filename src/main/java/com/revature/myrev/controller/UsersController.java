package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.UsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService service;

}

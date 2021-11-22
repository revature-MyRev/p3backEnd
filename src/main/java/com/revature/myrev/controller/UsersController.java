package com.revature.myrev.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.exception.ObjectNotFoundException;
import com.revature.myrev.exception.ValidationException;
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
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users findByUserName(@PathVariable String userName) {
		Users user = service.findByUserName(userName);
		if (Objects.isNull(user)) {
			throw new ObjectNotFoundException("Not Found");
		}
		return user;
	}

	@PostMapping(path = "/addUser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users addUser(@RequestBody Users user) {
		validate(user);
		return service.save(user);
	}

	public void validate(Users user) {
		if (Objects.isNull(user.getUserName()) || Objects.isNull(user.getPassword())) {
			throw new ValidationException("Invalid user");
		}
	}

}

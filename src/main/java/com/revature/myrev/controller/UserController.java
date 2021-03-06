package com.revature.myrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.revature.myrev.service.UsersService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.revature.myrev.model.Users;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@EnableSwagger2
public class UserController {
	
	@Autowired
	private UsersService userService;
	
	@GetMapping("/findByUsername/{username}")
	public Users findFollowersByUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return userService.findByUserName(username);
	}

	@GetMapping("/findUserById/{id}")
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

	/**
	 * Requests user from service that matches the given user name
	 * 
	 * @param userName The user name associated with the user to be retrieved.
	 * @return The user associated with the given user name.
	 */
	@GetMapping(path = "/findByUserName/{userName}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users findByUserName(@PathVariable String userName) {
		return userService.findByUserName(userName);
	}
	
	/**
	 * Sends a user object to service to save in the database
	 * 
	 * @param user The user object to be added to the database.
	 * @return The user object saved in the database with an updated user id.
	 */
    @PostMapping(path = "/addUser")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Users addUser(@RequestBody Users user) {
    	return userService.save(user);
    }
//    
//    public void validate(Users user) {
//		if(Objects.isNull(user.getUserName()) || Objects.isNull(user.getPassword())) {
//			throw new ValidationException("Invalid user");
//		}
//	}

@PutMapping("/editProfile/{id}")
public void editUser(@PathVariable(value ="id") int id, @RequestBody Users user) {
	user.setUserId(id);
	userService.save(user);
}

@PutMapping("/uploadPhoto/{id}")
public void uploadPicture(@PathVariable(value = "id") int id,@RequestBody String imgurl) {
	Users user = userService.findById(id);
	user.setUserId(id);
	user.setPhoto(imgurl);
	userService.save(user);
}

@GetMapping("/getPhoto/{id}")
public String getUserPhoto(@PathVariable(value = "id") int id) {
	Users user = userService.findById(id);
	return user.getPhoto();
}


}

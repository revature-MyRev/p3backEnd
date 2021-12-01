package com.revature.myrev.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.revature.myrev.service.UsersService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.revature.myrev.model.ERole;
import com.revature.myrev.model.Role;
import com.revature.myrev.model.Users;
import com.revature.myrev.repository.RoleRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@EnableSwagger2
public class UserController {
	
	@Autowired
	private UsersService userService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/findByUsername/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users findFollowersByUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return userService.findByUserName(username);
	}

	@GetMapping("/findById/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Users findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}

	@PostMapping("/users")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void save(Users user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		userService.save(user);
	}

	@PutMapping("/users/{id}")
	@PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
	public void update(@PathVariable int id, Users user) {
		userService.save(user);

	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
	public void delete(@PathVariable int id) {
		userService.deleteById(id);

	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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
@PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
public void editUser(@PathVariable(value ="id") int id, @RequestBody Users user) {
	user.setUserId(id);
	userService.save(user);
}

@PutMapping("/uploadPhoto/{id}")
@PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
public void uploadPicture(@PathVariable(value = "id") int id,@RequestBody String imgurl) {
	Users user = userService.findById(id);
	user.setUserId(id);
	user.setPhoto(imgurl);
	userService.save(user);
}

@GetMapping("/getPhoto/{id}")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public String getUserPhoto(@PathVariable(value = "id") int id) {
	Users user = userService.findById(id);
	return user.getPhoto();
}


}

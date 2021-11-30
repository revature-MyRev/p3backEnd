package com.revature.myrev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.myrev.model.Users;
import com.revature.myrev.repository.UsersRepository;

//implements UserDetails, part of Spring Security
//implements a findByUsername function for the class
@Service
public class UsersDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsersRepository userRepository;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = null;
		try{
			users = userRepository.findByUserName(username);
		}
		catch(UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);

		}
		if(users == null) // Null pointer exceptions were happening.
			return null;
		else
			return UsersDetailsImpl.build(users);
	}
}

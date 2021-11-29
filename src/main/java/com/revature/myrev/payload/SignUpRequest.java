package com.revature.myrev.payload;

import java.util.Set;


//Class sent by angular upon attempting to sign up, 
//only sets up a user with username, name, email, password, and roles(for access authorization)
//more can be added if more details are to be set up at registration
public class SignUpRequest {

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Set<String> role;

	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpRequest(String username, String firstName, String lastName, String email, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

}

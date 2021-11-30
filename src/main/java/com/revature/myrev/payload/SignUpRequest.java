package com.revature.myrev.payload;

import java.util.Set;


//Class sent by angular upon attempting to sign up, 
//only sets up a user with username, name, email, password, and roles(for access authorization)
//more can be added if more details are to be set up at registration
public class SignUpRequest {

	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Set<String> role;

	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpRequest(String username, String firstname, String lastname, String email, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@Override
	public String toString() {
		return "SignUpRequest [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	
}

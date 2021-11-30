package com.revature.myrev.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.revature.myrev.model.Users;


//implements UserDetails, part of Spring Security
//holds user id, username, email, and password from the user
public class UsersDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private int id;

	private String usersname;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UsersDetailsImpl(int id, String usersname, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.usersname = usersname;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UsersDetailsImpl build(Users users) {
		List<GrantedAuthority> authorities = users.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UsersDetailsImpl(users.getUserId(), users.getUserName(), users.getEmail(), users.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return usersname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UsersDetailsImpl users = (UsersDetailsImpl) o;
		return Objects.equals(id, users.id);
	}
}

package com.revature.myrev.servicestests;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
//import com.google.common.base.Optional;
import com.revature.myrev.model.User;
import com.revature.myrev.repository.UserRepository;
import com.revature.myrev.service.UserService;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	 @Mock
     private UserRepository userRepository;
	
	 @Autowired
	 @InjectMocks
     private UserService userService;
	 private User u1; 
	 private User u2;
	 List<User> userList;
    //private UserRepository userRepo;
	
	 @BeforeEach
	 public void setUp() {
		 userList = new ArrayList<>();
		 u1 = new User(1, 16, "bob", "password", "male", "test", "test@gmail.com", "Bob", "Smith", "Middle", "Constructor");
		 u2 = new User(2, 18, "joe", "password", "male", "test", "test2@gmail.com", "Joe", "Middle", "Adams", "Instructor");
		 userList.add(u1);
		 userList.add(u2);
	 }
	 
	 @AfterEach
	 public void tearDown() {
		 u1 = u2 = null;
		 userList = null;
	 }
	 
	 @Test 
	 void givenUserToAddShouldReturnAddedUser() {
		 when(userRepository.save(any())).thenReturn(u1);
		 userService.save(u1);
		 verify(userRepository, times(1)).save(any());
		 
	 }
	 
	 @Test
	 public void GivenGetAllUsersShouldReturnListOfAllUsers(){
	      userRepository.save(u1);
	     //stubbing mock to return specific data
	     when(userRepository.findAll()).thenReturn(userList);
	     List<User> userList1 = userService.findAll();
	     assertEquals(userList1,userList);
	     verify(userRepository,times(1)).save(u1);
	     verify(userRepository,times(1)).findAll();
	 }
	 
	 
	 @Test
	 public void givenIdThenShouldReturnUserOfThatId() {
	    Mockito.when(userRepository.findById(1)).thenReturn(Optional.ofNullable(u1));
	    assertThat(userService.findById(u1.getUserId())).isEqualTo(u1);
	 }
	 
	 
//	 @Test
//	 public void givenIdTODeleteThenShouldDeleteTheUser(){
//	     when(userService.(u1.getUserId())).thenReturn(u1);
//	 //assertThat(productService.);
//	     verify(userRepository,times(1)).findAll();
//	 }
	 
	 
}

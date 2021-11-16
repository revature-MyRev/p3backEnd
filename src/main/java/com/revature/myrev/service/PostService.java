package com.revature.myrev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.myrev.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;

}

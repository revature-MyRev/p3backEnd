package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.PostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService service;
}

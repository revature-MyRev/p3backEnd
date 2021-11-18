package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.FollowerService;
import com.revature.myrev.service.FollowerServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/followers")
public class FollowerController {
	
	@Autowired
	private FollowerServiceImpl service;

}

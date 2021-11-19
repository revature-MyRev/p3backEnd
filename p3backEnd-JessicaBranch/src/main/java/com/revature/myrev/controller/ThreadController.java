package com.revature.myrev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.ThreadService;
import com.revature.myrev.service.ThreadServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/threads")
public class ThreadController {
    
	@Autowired
	private ThreadServiceImpl service;
}

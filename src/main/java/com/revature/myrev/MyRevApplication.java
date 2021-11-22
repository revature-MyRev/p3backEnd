package com.revature.myrev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.myrev.model.Post;

@SpringBootApplication
public class MyRevApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRevApplication.class, args);
		
		Post post = new Post();
	}

}

package com.revature.myrev;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.myrev.model.Post;
import com.revature.myrev.model.Feed;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyRevApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRevApplication.class, args);
	
	
		
	}

}

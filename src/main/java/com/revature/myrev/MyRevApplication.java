package com.revature.myrev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyRevApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRevApplication.class, args);
	}

}

package com.revature.myrev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.myrev.model.ERole;
import com.revature.myrev.model.Role;
import com.revature.myrev.repository.RoleRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyRevApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRevApplication.class, args);
    }
    
    @Bean
    CommandLineRunner run(RoleRepository roleRepo) {
        return args -> {
            if (roleRepo.findAll().size() == 0) {
                roleRepo.save(new Role(0, ERole.ROLE_USER));
                roleRepo.save(new Role(0, ERole.ROLE_ADMIN));
            }
        };
    }

}
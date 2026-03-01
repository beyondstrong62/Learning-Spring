package com.example.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringExampleApplication.class, args);
        UserManager userManager = new UserManager();
        String userData = userManager.getUserData();
        System.out.println(userData);
    }

}

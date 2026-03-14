package com.embarkx.FirstSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello(){
        return new HelloResponse("Hello World !");
    }

    @PostMapping("/hello")
    public String hellopost(@RequestBody String name) {
        System.out.println("POST called with: " + name);
        return "Hello " + name + " !";
    }
}

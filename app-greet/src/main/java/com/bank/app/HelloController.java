package com.bank.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "Welcome to Banking API";
    }


    @PostMapping("")
    public String getUser(@RequestBody String name) {
        System.out.println("POST called with: " + name);
        return "Hello " + name + "Welcome to Banking API !";
    }




}

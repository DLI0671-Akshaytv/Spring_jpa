package com.example.Java_day22_Assignment.controller;

import com.example.Java_day22_Assignment.model.User;
import com.example.Java_day22_Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping("/addUsers")
    public String addUser(@RequestBody User user) {

        if(user != null) {
            userService.addUser(user);
            log.info("Added a new User");
            return ("Added a user");
        } else {
            log.error("Request does not contain a body");
            return("Error");
        }

    }
}

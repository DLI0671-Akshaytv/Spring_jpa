package com.example.Java_day22_Assignment.controller;

import com.example.Java_day22_Assignment.model.User;
import com.example.Java_day22_Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PatchMapping("/editEmail")
    public User updateEmail(@RequestBody User user){
        return userService.UpdateUserEmail(user.getId(), user.getEmail());
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id")long id){
        return userService.delete(id);
    }

    @PostMapping("/addListOfUsers")
    public boolean addUsers(@RequestBody List<User>users){
        return userService.addUsers(users);
    }
    @PatchMapping("/editListOfEmail")
    public boolean updateListEmail(@RequestBody List<User> users){
        return userService.updatelistOfUsers(users);
    }
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getallusers();
    }
    @GetMapping("/users/by-domain/{domain}")
    public List<User> getUsersEmailDomain(@PathVariable("domain") String domain){
        return userService.getUserEmailbyDomain(domain);
    }

    @GetMapping("/users/count")
    public int getusersCount(){
        return userService.userCount();
    }



}

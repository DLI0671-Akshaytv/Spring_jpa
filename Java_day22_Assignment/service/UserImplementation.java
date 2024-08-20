package com.example.Java_day22_Assignment.service;

import com.example.Java_day22_Assignment.model.User;
import com.example.Java_day22_Assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation implements UserService{
    @Autowired
    UserRepo repository;
    @Override
    public User addUser(User user) {
        return repository.save(user);
    }
}

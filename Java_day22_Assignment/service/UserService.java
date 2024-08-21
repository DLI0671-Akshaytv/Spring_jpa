package com.example.Java_day22_Assignment.service;

import com.example.Java_day22_Assignment.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User findById(long id);
    User UpdateUserEmail(long id, String email);
    boolean delete(long id);
    boolean addUsers(List<User>users);
    boolean updatelistOfUsers(List <User>users);
    List<User>getallusers();
    List<User>getUserEmailbyDomain(String domain);
    int userCount();


}

package com.example.Java_day22_Assignment.service;

import com.example.Java_day22_Assignment.model.User;
import com.example.Java_day22_Assignment.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserImplementation.class);
    @Autowired
    UserRepo repository;
    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findById(long id) {
        Optional<User> result = repository.findById(id);
        return result.orElse(null);
    }

    @Override
    public User UpdateUserEmail(long id, String email) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(email);
            repository.save(user);
            System.out.println("User email updated successfully.");
            return user;
        } else {
            System.out.println("No user found with the given ID.");
            return null;
        }

    }

    @Override
    public boolean delete(long id) {
        User user = repository.findById(id).orElse(null);
        if(user!=null){
            repository.deleteById(id);
            log.info("User deleted Successfully!");
            return true;
        }
        else{
            log.error("User not exists!");
            return false;
        }
    }

    @Override
    public boolean addUsers(List<User> users) {
        for(User user:users){
            repository.save(user);
        }
        return true;
    }

    @Override
    public boolean updatelistOfUsers(List<User> users) {
        for(User u:users){
            if(repository.findById(u.getId()).isPresent()){
                u.setEmail(u.getEmail());
            }
        }
        return true;
    }

    @Override
    public List<User> getallusers() {
        return repository.getAllUsers();
    }

    @Override
    public List<User> getUserEmailbyDomain(String domain) {
        return repository.getUsersEmailDomain(domain);
    }

    @Override
    public int userCount() {
        return repository.getUSerCount();
    }


}

package com.example.Java_day22_Assignment.repository;

import com.example.Java_day22_Assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
//    @Query("INSERT INTO users (name, email) VALUES (?, ?);")
//    public User addUsers(name,email);
}

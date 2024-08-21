package com.example.Java_day22_Assignment.repository;

import com.example.Java_day22_Assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

    @Query("select u from User u where u.email like %:domain")
    List<User> getUsersEmailDomain(@Param("domain")String params);

    @Query("select count(u) from User u")
    int getUSerCount();


}

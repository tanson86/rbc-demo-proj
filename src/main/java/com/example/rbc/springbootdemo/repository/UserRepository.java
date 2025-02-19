package com.example.rbc.springbootdemo.repository;

import com.example.rbc.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT DISTINCT user FROM User user " +
            "JOIN FETCH user.posts post")
    List<User> findAllEager();
}

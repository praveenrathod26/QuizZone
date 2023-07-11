package com.example.quizzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizzone.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods for user entity
}
package com.assignment.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.college.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Custom query method to find a user by username
}

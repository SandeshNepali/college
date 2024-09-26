package com.sajan.collegeproject.repo;


import com.sajan.collegeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find a user by email
    User findByUsername(String username);
}

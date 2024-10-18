package com.assignment.college.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "User")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensures auto-increment
    private Long id;
    
    private String username;
    private String password;
    private String email; // New field for email

    // Constructors
    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email; // Initialize email
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    // No setter for id to prevent manual setting

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email; // Getter for email
    }

    public void setEmail(String email) {
        this.email = email; // Setter for email
    }
}

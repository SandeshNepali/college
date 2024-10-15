package com.assignment.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.college.entity.User;
import com.assignment.college.repo.UserRepository;
import com.assignment.college.utility.HashingUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class Login {
    @Autowired
    private UserRepository userRepository;

    // Show login form
    @GetMapping({"/", "/login"})
    public String showLoginForm(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("username", loggedInUser.getUsername());
            return "redirect:/home"; // Show home page with user details
        }
        model.addAttribute("user", new User()); // Add empty user object for binding
        return "login";
    }

    // Handle login request
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, jakarta.servlet.http.HttpSession session) {

        // Check if the user exists in the database
        User existingUser = userRepository.findByUsername(user.getUsername());
        String hashedPassword = HashingUtil.hashPassword(user.getPassword());

        if (existingUser != null && existingUser.getPassword().equals(hashedPassword)) {
            session.setAttribute("loggedInUser", existingUser); // Store user in session
            return "redirect:/home";
        }

        // If login fails, show error
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // Logout endpoint
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login"; // Redirect to login page after logout
    }

}

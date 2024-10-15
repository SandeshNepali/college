package com.assignment.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.college.entity.User;
import com.assignment.college.repo.UserRepository;
import com.assignment.college.utility.HashingUtil;


@Controller
public class Register {

    @Autowired
    private UserRepository userRepository;

    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Add empty user object for binding
        return "register";
    }

    // Handle registration request
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, @RequestParam String confirmPassword, Model model) {
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        String hashedPassword = HashingUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return "redirect:/login";
    }
}



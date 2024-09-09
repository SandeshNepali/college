package com.java.example.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @GetMapping("/")
    public String home() {
        return "home"; // Maps to home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Maps to login.html
    }
}

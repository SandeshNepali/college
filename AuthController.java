// package com.assignment.college.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import com.assignment.college.entity.User;
// import com.assignment.college.repo.UserRepository;
// import com.assignment.college.utility.HashingUtil;

// import jakarta.servlet.http.HttpSession;



// @Controller
// public class AuthController {

//     @Autowired
//     private UserRepository userRepository;

//     // Show login form
//     @GetMapping("/login")
//     public String showLoginForm(HttpSession session, Model model) {
//         User loggedInUser = (User) session.getAttribute("loggedInUser");
//         if (loggedInUser != null) {
//             model.addAttribute("username", loggedInUser.getUsername());
//             return "redirect:/home"; // Show home page with user details
//         }
//         model.addAttribute("user", new User()); // Add empty user object for binding
//         return "login";
//     }

//     // Handle login request
//     @PostMapping("/login")
//     public String login(@ModelAttribute("user") User user, Model model, jakarta.servlet.http.HttpSession session) {

//         // Check if the user exists in the database
//         User existingUser = userRepository.findByUsername(user.getUsername());
//         String hashedPassword = HashingUtil.hashPassword(user.getPassword());

//         if (existingUser != null && existingUser.getPassword().equals(hashedPassword)) {
//             session.setAttribute("loggedInUser", existingUser); // Store user in session
//             return "redirect:/home";
//         }

//         // If login fails, show error
//         model.addAttribute("error", "Invalid username or password");
//         return "login";
//     }

//     // Show registration form
//     @GetMapping("/register")
//     public String showRegistrationForm(Model model) {
//         model.addAttribute("user", new User()); // Add empty user object for binding
//         return "register";
//     }

//     // Handle registration request
//     @PostMapping("/register")
//     public String register(@ModelAttribute("user") User user, @RequestParam String confirmPassword, Model model) {
//         if (!user.getPassword().equals(confirmPassword)) {
//             model.addAttribute("error", "Passwords do not match");
//             return "register";
//         }

//         String hashedPassword = HashingUtil.hashPassword(user.getPassword());
//         user.setPassword(hashedPassword);

//         userRepository.save(user);

//         return "redirect:/login";
//     }

//     // Sample home page after login
//     @GetMapping("/home")
//     public String showHomePage(HttpSession session, Model model) {
//         User loggedInUser = (User) session.getAttribute("loggedInUser");
//         if (loggedInUser != null) {
//             model.addAttribute("username", loggedInUser.getUsername());
//             return "home"; // Show home page with user details
//         }
//         return "redirect:/login"; // Redirect to login if no user is found in session
//     }

//     // Logout endpoint
//     @GetMapping("/logout")
//     public String logout(HttpSession session) {
//         session.invalidate(); // Invalidate the session
//         return "redirect:/login"; // Redirect to login page after logout
//     }
// }

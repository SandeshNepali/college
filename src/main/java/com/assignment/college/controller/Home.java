package com.assignment.college.controller;

import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;
import com.assignment.college.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class Home {

    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("username", loggedInUser.getUsername());

            // Fetch tasks for the logged-in user
            List<Task> userTasks = taskService.getTasksByUser(loggedInUser);
            model.addAttribute("tasks", userTasks);  // Add tasks to the model

            return "home"; // Show home page with user tasks
        }
        return "redirect:/login"; // Redirect to login if no user is found in session
    }
}



























// package com.assignment.college.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import jakarta.servlet.http.HttpSession;
// import com.assignment.college.entity.User;

// @Controller
// public class Home {
//     @GetMapping("/home")
//     public String showHomePage(HttpSession session, Model model) {
//         User loggedInUser = (User) session.getAttribute("loggedInUser");
//         if (loggedInUser != null) {
//             model.addAttribute("username", loggedInUser.getUsername());
//             return "home"; // Show home page with user details
//         }
//         return "redirect:/login"; // Redirect to login if no user is found in session
//     }
// }




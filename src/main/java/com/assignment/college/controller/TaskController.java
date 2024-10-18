package com.assignment.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;
import com.assignment.college.service.TaskService;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if (loggedInUser != null) {
            // Retrieve tasks specific to the logged-in user using the user ID
            List<Task> tasks = taskService.getTasksByUser(loggedInUser);
            model.addAttribute("tasks", tasks);
            return "task-list"; // Returns the task list view
        }
    
        model.addAttribute("user", new User()); // Add empty user object for binding
        return "login"; // Redirect to the login page if the user is not logged in
    }
    

    @GetMapping("/new")
    public String showTaskForm(HttpSession session,Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("task", new Task());
            return "task-form";
        }
        model.addAttribute("user", new User()); // Add empty user object for binding
        return "login";



        // model.addAttribute("task", new Task());
        // return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            task.setUser(loggedInUser); // Link task to logged-in user
            taskService.saveTask(task);
            return "redirect:/tasks";
        }
        return "redirect:/login"; // Redirect to login if no user is in session
    }

    @GetMapping("/view/{id}")
    public String getTaskById(@PathVariable("id") Long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        // System.out.println(id);
        // System.out.println("sadfkas;dl");
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task-details";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task-form";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}

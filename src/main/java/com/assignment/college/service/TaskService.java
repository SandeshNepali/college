package com.assignment.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.college.repo.TaskRepository;
import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Create or update a task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Method to fetch tasks for a specific user
    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user); // Calls TaskRepository method
    }
}

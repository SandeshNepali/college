package com.assignment.college;

import org.junit.jupiter.api.Test;

import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskConstructorAndGetters() {
        Task task = new Task();
        task.setTitle("Test Title");
        task.setDescription("Test Description");
        task.setStatus("Pending");
        task.setDueDate("2024-12-31");
        
        User user = new User("username", "password", "test@example.com");
        task.setUser(user);

        assertNotNull(task);
        assertEquals("Test Title", task.getTitle());
        assertEquals("Test Description", task.getDescription());
        assertEquals("Pending", task.getStatus());
        assertEquals("2024-12-31", task.getDueDate());
        assertEquals(user, task.getUser());
    }

    @Test
    public void testTaskSetterAndGetter() {
        Task task = new Task();
        
        task.setTitle("Task 1");
        assertEquals("Task 1", task.getTitle());

        task.setDescription("This is a test task");
        assertEquals("This is a test task", task.getDescription());

        task.setStatus("In Progress");
        assertEquals("In Progress", task.getStatus());

        task.setDueDate("2024-01-01");
        assertEquals("2024-01-01", task.getDueDate());
    }

    @Test
    public void testUserSetterAndGetter() {
        Task task = new Task();
        User user = new User("username", "password", "test@example.com");

        task.setUser(user);
        assertEquals(user, task.getUser());
    }

    @Test
    public void testDefaultConstructor() {
        Task task = new Task();
        assertNotNull(task);
        assertNull(task.getTitle());
        assertNull(task.getDescription());
        assertNull(task.getStatus());
        assertNull(task.getDueDate());
        assertNull(task.getUser());
    }
}

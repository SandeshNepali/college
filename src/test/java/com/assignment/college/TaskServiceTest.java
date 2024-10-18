package com.assignment.college;

import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;
import com.assignment.college.repo.TaskRepository;
import com.assignment.college.service.TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Task Description");
        task.setStatus("Pending");
        task.setDueDate("2024-12-31");

        User user = new User("username", "password", "test@example.com");
        task.setUser(user);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        when(taskRepository.findAll()).thenReturn(taskList);

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    public void testGetTaskById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> foundTask = taskService.getTaskById(1L);
        assertTrue(foundTask.isPresent());
        assertEquals("Test Task", foundTask.get().getTitle());
    }

    @Test
    public void testSaveTask() {
        when(taskRepository.save(task)).thenReturn(task);

        Task savedTask = taskService.saveTask(task);
        assertNotNull(savedTask);
        assertEquals("Test Task", savedTask.getTitle());
    }

    @Test
    public void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(1L);
        assertDoesNotThrow(() -> taskService.deleteTask(1L));
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetTasksByUser() {
        List<Task> userTasks = new ArrayList<>();
        userTasks.add(task);

        User user = new User("username", "password", "test@example.com");
        when(taskRepository.findByUser(user)).thenReturn(userTasks);

        List<Task> tasksByUser = taskService.getTasksByUser(user);
        assertEquals(1, tasksByUser.size());
        assertEquals("Test Task", tasksByUser.get(0).getTitle());
    }

    // @Test
    // public void testTaskTitleShouldFail() {
    //     Task task = new Task();
    //     task.setTitle("Test Task");

    //     // Intentionally causing a failure
    //     assertEquals("Incorrect Title", task.getTitle(), "This title should fail the test!");
    // }
}

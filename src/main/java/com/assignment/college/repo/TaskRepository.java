package com.assignment.college.repo;

import com.assignment.college.entity.Task;
import com.assignment.college.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Custom query method to find tasks by a specific user
    List<Task> findByUser(User user);
}

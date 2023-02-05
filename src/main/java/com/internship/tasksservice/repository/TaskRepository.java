package com.internship.tasksservice.repository;

import com.internship.tasksservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> deleteTaskByTaskIdAndUserId(Long taskId, Long userId);

    Optional<Task> findByTaskIdAndUserId(Long taskId, Long userId);

    List<Task> getAllByUserId(Long userId);
}

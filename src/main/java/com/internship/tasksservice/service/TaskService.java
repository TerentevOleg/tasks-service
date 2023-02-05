package com.internship.tasksservice.service;

import com.internship.tasksservice.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(Long taskId, TaskDto taskDto, Long userId);

    TaskDto getTaskById(Long taskId, Long userId);

    List<TaskDto> getAllTasks(Long userId);

    void deleteTask(Long taskId, Long userId);
}

package com.internship.tasksservice.controller;

import com.internship.tasksservice.dto.TaskDto;
import com.internship.tasksservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId,
                               @RequestParam Long userId) {
        return taskService.getTaskById(taskId, userId);
    }

    @PostMapping("/{taskId}")
    public TaskDto addTask(@PathVariable Long taskId,
                           @RequestBody TaskDto taskDto,
                           @RequestParam Long userId) {
        return taskService.addTask(taskId, taskDto, userId);
    }

    @GetMapping
    public List<TaskDto> getAllTasks(@RequestParam Long userId) {
        return taskService.getAllTasks(userId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId,
                           @RequestParam Long userId) {
        taskService.deleteTask(taskId, userId);
    }
}

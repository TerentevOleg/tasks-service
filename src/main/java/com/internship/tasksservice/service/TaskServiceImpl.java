package com.internship.tasksservice.service;

import com.internship.tasksservice.dto.TaskDto;
import com.internship.tasksservice.exception.NotFoundException;
import com.internship.tasksservice.mapper.TaskMapper;
import com.internship.tasksservice.model.Task;
import com.internship.tasksservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    @Transactional
    public TaskDto addTask(Long taskId, TaskDto taskDto, Long userId) {
        Task task = taskRepository.save(taskMapper.fromDto(taskDto));
        //log.debug("TaskServiceImpl: add task " + task + ".");
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto getTaskById(Long taskId, Long userId) {
        return taskMapper.toDto(
                taskRepository.findByTaskIdAndUserId(taskId, userId)
                        .orElseThrow(
                                () -> new NotFoundException("TaskServiceImpl: task with id=" + taskId + " not found.")
                        )
        );
    }

    @Override
    public List<TaskDto> getAllTasks(Long userId) {
        return null;
        /*return taskRepository.getAllByUserId(userId)
                .stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());*/
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteTask(Long taskId, Long userId) {
        try {
            taskRepository.deleteTaskByTaskIdAndUserId(taskId, userId);
        } catch (EmptyResultDataAccessException e) {
            //log.debug(e.getMessage(), e);
            throw new NotFoundException("TaskServiceImpl: task with id=" + taskId + " not found.");
        }
        //log.debug("TaskServiceImpl: delete task id=" + taskId + ".");
    }
}

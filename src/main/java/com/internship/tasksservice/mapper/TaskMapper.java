package com.internship.tasksservice.mapper;

import com.internship.tasksservice.dto.TaskDto;
import com.internship.tasksservice.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    @Mapping(target = "id", ignore = true)
    Task fromDto(TaskDto taskDto);
}

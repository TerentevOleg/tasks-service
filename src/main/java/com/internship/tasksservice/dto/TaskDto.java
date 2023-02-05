package com.internship.tasksservice.dto;

import lombok.Value;

@Value
public class TaskDto {

    Long id;

    String name;

    Boolean status;
}

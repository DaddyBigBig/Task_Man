package com.chrism.taskman.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.chrism.taskman.domain.entities.TaskPriority;
import com.chrism.taskman.domain.entities.TaskStatus;

public record TaskDto(

    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status

) {
    
    

}

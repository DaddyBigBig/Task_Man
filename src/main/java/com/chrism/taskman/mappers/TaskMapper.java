package com.chrism.taskman.mappers;

import com.chrism.taskman.domain.dto.TaskDto;
import com.chrism.taskman.domain.entities.Task;

public interface TaskMapper {
    
    Task fromDto(TaskDto taskDto);
    
    TaskDto toDto(Task task);

}

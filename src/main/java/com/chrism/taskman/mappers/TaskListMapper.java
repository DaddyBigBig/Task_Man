package com.chrism.taskman.mappers;

import com.chrism.taskman.domain.dto.TaskListDto;
import com.chrism.taskman.domain.entities.TaskList;

public interface TaskListMapper {
    
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}

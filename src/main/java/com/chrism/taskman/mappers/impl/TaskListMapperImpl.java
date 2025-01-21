package com.chrism.taskman.mappers.impl;

import java.util.List;
import java.util.Optional;

import com.chrism.taskman.domain.dto.TaskListDto;
import com.chrism.taskman.domain.entities.Task;
import com.chrism.taskman.domain.entities.TaskList;
import com.chrism.taskman.domain.entities.TaskStatus;
import com.chrism.taskman.mappers.TaskListMapper;
import com.chrism.taskman.mappers.TaskMapper;

public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
            taskListDto.id(),
            taskListDto.title(),
            taskListDto.description(),
            Optional.ofNullable(taskListDto.tasks())
                    .map(tasks -> tasks.stream()
                            .map(taskMapper::fromDto)
                            .toList()
                        ).orElse(null),
            null,
            null                 
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        
        return new TaskListDto(
            taskList.getId(),
            taskList.getTitle(),
            taskList.getDescription(),
            Optional.ofNullable(taskList.getTasks())
                    .map(tasks -> tasks.size())
                    .orElse(0),
            taskListProgress(taskList.getTasks()),
            Optional.ofNullable(taskList.getTasks())
                    .map(tasks -> tasks.stream()
                            .map(taskMapper::toDto)
                            .toList()
                        ).orElse(null)
        );
        
    }

    private Double taskListProgress(List<Task> tasks) {

        if (null == tasks) {
            return null;
        }

        long closedTaskCount = tasks.stream().filter(task -> 
                TaskStatus.CLOSED == task.getStatus()
                ).count();

        return (double) closedTaskCount / tasks.size();

    }
    
}

package com.chrism.taskman.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrism.taskman.domain.dto.TaskDto;
import com.chrism.taskman.domain.entities.Task;
import com.chrism.taskman.mappers.TaskMapper;
import com.chrism.taskman.services.TaskService;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {

    
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
 
    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id") UUID taskListId) {

        return taskService.listTasks(taskListId)
                    .stream()
                    .map(taskMapper::toDto)
                    .toList();

    }

    @PostMapping
    public TaskDto listTasks(@RequestBody TaskDto taskDto) {

        Task createdTask = taskService.createTask(
            taskMapper.fromDto(taskDto)
        );

        return taskMapper.toDto(createdTask);

    }

    
}

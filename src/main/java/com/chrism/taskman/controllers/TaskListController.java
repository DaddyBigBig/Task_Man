package com.chrism.taskman.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrism.taskman.domain.dto.TaskListDto;
import com.chrism.taskman.domain.entities.TaskList;
import com.chrism.taskman.mappers.TaskListMapper;
import com.chrism.taskman.services.TaskListService;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {

        this.taskListMapper = taskListMapper;
        this.taskListService = taskListService;

    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {

        return taskListService.listTaskLists()
                    .stream()
                    .map(taskListMapper::toDto)
                    .toList();

    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {

        TaskList createdTaskList = taskListService.createTaskList(
            taskListMapper.fromDto(taskListDto)
            );

        return taskListMapper.toDto(createdTaskList);

    }

    
}

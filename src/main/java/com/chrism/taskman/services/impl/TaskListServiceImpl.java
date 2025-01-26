package com.chrism.taskman.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chrism.taskman.domain.entities.TaskList;
import com.chrism.taskman.repositories.TaskListRepository;
import com.chrism.taskman.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {

        this.taskListRepository = taskListRepository;

    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {

        if (null != taskList.getId()) {
            throw new IllegalArgumentException("Task List already has an ID");
        }
        if (null == taskList.getTitle() || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task List needs a Title");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
            null,
            taskList.getTitle(),
            taskList.getDescription(),
            null,
            now,
            now
        ));
    }
    
}

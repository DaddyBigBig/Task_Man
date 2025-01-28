package com.chrism.taskman.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chrism.taskman.domain.entities.Task;
import com.chrism.taskman.domain.entities.TaskList;
import com.chrism.taskman.domain.entities.TaskPriority;
import com.chrism.taskman.domain.entities.TaskStatus;
import com.chrism.taskman.repositories.TaskRepository;
import com.chrism.taskman.services.TaskService;

public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(Task task) {

        if (null != task.getId()) {
            throw new IllegalArgumentException("Task already has an ID");
        }
        if (null == task.getTitle() || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task needs a Title");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
            .orElse(TaskPriority.MEDIUM);

        LocalDateTime now = LocalDateTime.now();
        return taskRepository.save(new Task(
            null,
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            TaskStatus.OPEN,
            taskPriority,
            now,
            now
        ));
    }

    
    
}

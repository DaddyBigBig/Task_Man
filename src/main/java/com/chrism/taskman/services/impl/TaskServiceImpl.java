package com.chrism.taskman.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chrism.taskman.domain.entities.Task;
import com.chrism.taskman.domain.entities.TaskList;
import com.chrism.taskman.domain.entities.TaskPriority;
import com.chrism.taskman.domain.entities.TaskStatus;
import com.chrism.taskman.repositories.TaskListRepository;
import com.chrism.taskman.repositories.TaskRepository;
import com.chrism.taskman.services.TaskService;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {

        if (null != task.getId()) {
            throw new IllegalArgumentException("Task already has an ID");
        }
        if (null == task.getTitle() || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task needs a Title");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
            .orElse(TaskPriority.MEDIUM);

        TaskList taskList = taskListRepository
            .findById(taskListId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Task List"));

        LocalDateTime now = LocalDateTime.now();
        
        Task taskToSave = new Task(
            null,
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            TaskStatus.OPEN,
            taskPriority,
            taskList,
            now,
            now
        );

        return taskRepository.save(taskToSave);

    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository
            .findByTaskListIdAndId(taskListId, taskId);

    }

    
    
}

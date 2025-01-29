package com.chrism.taskman.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chrism.taskman.domain.entities.Task;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID tasklistId, Task task);
    Optional<Task> getTask(UUID taskListId, UUID taskId);
    Task updateTask(UUID taskListId, UUID taskId, Task task);
    void deleteTask(UUID taskListId, UUID task);
}

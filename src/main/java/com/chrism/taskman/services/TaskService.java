package com.chrism.taskman.services;

import java.util.List;
import java.util.UUID;

import com.chrism.taskman.domain.entities.Task;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
}

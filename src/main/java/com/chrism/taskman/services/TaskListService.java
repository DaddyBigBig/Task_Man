package com.chrism.taskman.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chrism.taskman.domain.entities.TaskList;

public interface TaskListService {
    
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList> getTaskList(UUID id);
    TaskList updateTaskList(UUID taskListId, TaskList taskList);
    void deleteTask(UUID taskListId);

}

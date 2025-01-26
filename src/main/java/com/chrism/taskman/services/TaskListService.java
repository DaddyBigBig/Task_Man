package com.chrism.taskman.services;

import java.util.List;

import com.chrism.taskman.domain.entities.TaskList;

public interface TaskListService {
    
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);

}

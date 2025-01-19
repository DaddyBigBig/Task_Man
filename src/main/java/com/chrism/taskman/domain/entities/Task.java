package com.chrism.taskman.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Column(name = "priority", nullable = false)
    private TaskPriority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;


    public Task() {

    }

    public Task(UUID id, String title, String description, LocalDateTime dueDate, TaskStatus status, TaskPriority priority, LocalDateTime created, LocalDateTime updated) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;

    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskList geTaskList() {
        return taskList;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {return false;}
        Task task = (Task) o;
        return Objects.equals(this.id, task.id) && Objects.equals(this.title, task.title) && Objects.equals(this.description, task.description) && Objects.equals(this.dueDate, task.dueDate) && Objects.equals(this.status, task.status) && Objects.equals(this.priority, task.priority) && Objects.equals(this.taskList, task.taskList) && Objects.equals(this.created, task.created) && Objects.equals(this.updated, task.updated);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, priority, taskList, created, updated);
    }

    @Override
    public String toString() {

        return "Task{" + 
                "id=" + id +
                "title=" + title + '\'' +
                "description=" + description + '\'' +
                "dueDate=" + dueDate +
                "status=" + status +
                "priority=" + priority +
                "taskList=" + taskList +
                "created=" + created +
                "updated=" + updated +
                '}';

    }

}

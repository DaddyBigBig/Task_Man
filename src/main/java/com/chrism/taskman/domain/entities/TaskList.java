package com.chrism.taskman.domain.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;;

@Entity
@Table(name = "task_lists")
public class TaskList {

        
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "taskList", cascade = {
        CascadeType.REMOVE, CascadeType.PERSIST
    })
    private List<Task> tasks;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    
    public TaskList() {

    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime created, LocalDateTime updated) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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
        TaskList taskList = (TaskList) o;
        return Objects.equals(this.id, taskList.id) && Objects.equals(this.title, taskList.title) && Objects.equals(this.description, taskList.description) && Objects.equals(this.tasks, taskList.tasks) && Objects.equals(this.created, taskList.created) && Objects.equals(this.updated, taskList.updated);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, created, updated);
    }

    @Override
    public String toString() {

        return "Task{" + 
                "id=" + id +
                "title=" + title + '\'' +
                "description=" + description + '\'' +
                "tasks=" + tasks +
                "created=" + created +
                "updated=" + updated +
                '}';

    }
    
}

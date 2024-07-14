package com.hexagonal.task.infrastructure.entities;

import com.hexagonal.task.domain.models.Task;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private boolean completed;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public TaskEntity() {
    }

    public TaskEntity(String id, String title, String description, LocalDateTime creationDate, LocalDateTime modificationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.completed = completed;
    }

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.getModificationDate(), task.isCompleted());
    }

    public Task toDomainModel() {
        return new Task(this.id, this.title, this.description, this.creationDate, this.modificationDate, this.completed);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

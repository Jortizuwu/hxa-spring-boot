package com.hexagonal.task.infrastructure.controllers;

import com.hexagonal.task.application.services.TaskService;
import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }


    @RequestMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        return taskService.getTask(id).map(task -> ResponseEntity.status(HttpStatus.OK).body(task)).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listTasks());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task updateTask) {
        return taskService.updateTask(id, updateTask).map(task -> ResponseEntity.status(HttpStatus.OK).body(task)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("info/{id}")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAdditonalTaskInfo(id));
    }
}


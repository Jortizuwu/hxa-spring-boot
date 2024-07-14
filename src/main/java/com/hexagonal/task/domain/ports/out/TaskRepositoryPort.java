package com.hexagonal.task.domain.ports.out;

import com.hexagonal.task.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    Task save(Task task);

    Optional<Task> findById(String id);

    List<Task> findAll();

    boolean deleteById(String id);

    Optional<Task> updateTask(String id, Task updateTask);
}

package com.hexagonal.task.domain.ports.in;

import com.hexagonal.task.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(String id);

    List<Task> listTasks();
}

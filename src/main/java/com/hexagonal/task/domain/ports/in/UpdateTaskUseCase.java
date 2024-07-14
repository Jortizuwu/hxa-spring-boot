package com.hexagonal.task.domain.ports.in;


import com.hexagonal.task.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(String id, Task updateTask);
}

package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(String id, Task updateTask) {
        return this.taskRepositoryPort.updateTask(id, updateTask);
    }
}

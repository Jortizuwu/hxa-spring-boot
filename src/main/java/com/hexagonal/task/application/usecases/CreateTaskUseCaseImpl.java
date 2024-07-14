package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.save(task);
    }
}

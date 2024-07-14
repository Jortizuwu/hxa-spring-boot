package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    @Override
    public boolean deleteTask(String id) {
        return this.taskRepositoryPort.deleteById(id);
    }
}

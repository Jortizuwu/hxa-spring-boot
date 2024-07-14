package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }


    @Override
    public Optional<Task> getTask(String id) {
        return this.taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> listTasks() {
        return this.taskRepositoryPort.findAll();
    }
}

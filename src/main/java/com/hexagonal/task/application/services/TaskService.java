package com.hexagonal.task.application.services;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, DeleteTaskUseCase, UpdateTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    private final UpdateTaskUseCase updateTaskUseCase;

    private final RetrieveTaskUseCase retrieveTaskUseCase;

    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, UpdateTaskUseCase updateTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }


    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(String id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditonalTaskInfo(String id) {
        return getAdditionalTaskInfoUseCase.getAdditonalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(String id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> listTasks() {
        return retrieveTaskUseCase.listTasks();
    }

    @Override
    public Optional<Task> updateTask(String id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }
}

package com.hexagonal.task.infrastructure.repositories;

import com.hexagonal.task.domain.models.Task;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.task.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTask = jpaTaskRepository.save(taskEntity);
        return savedTask.toDomainModel();
    }

    @Override
    public Optional<Task> findById(String id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public boolean deleteById(String id) {
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Task> updateTask(String id, Task updateTask) {
        if (jpaTaskRepository.existsById(id)) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(updateTask);
            TaskEntity savedTask = jpaTaskRepository.save(taskEntity);
            return Optional.of(savedTask.toDomainModel());
        }
        return Optional.empty();
    }
}

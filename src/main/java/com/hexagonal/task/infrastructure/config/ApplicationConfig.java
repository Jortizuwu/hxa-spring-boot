package com.hexagonal.task.infrastructure.config;

import com.hexagonal.task.application.services.TaskService;
import com.hexagonal.task.application.usecases.*;
import com.hexagonal.task.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.task.domain.ports.out.ExternalServicePort;
import com.hexagonal.task.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.task.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.task.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(new CreateTaskUseCaseImpl(taskRepositoryPort), new DeleteTaskUseCaseImpl(taskRepositoryPort), new UpdateTaskUseCaseImpl(taskRepositoryPort), new RetrieveTaskUseCaseImpl(taskRepositoryPort), getAdditionalTaskInfoUseCase);
    }

    @Bean
    TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}

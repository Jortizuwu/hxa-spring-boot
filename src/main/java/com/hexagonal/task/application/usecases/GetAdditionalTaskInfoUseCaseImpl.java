package com.hexagonal.task.application.usecases;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.task.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditonalTaskInfo(String id) {
        return this.externalServicePort.getAdditonalTaskInfo(id);
    }
}

package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.SpecializationEntity;
import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpecializationRequestConverter implements Function<SpecializationRequest, SpecializationEntity> {
    @Override
    public SpecializationEntity apply(SpecializationRequest specializationRequest) {
        return SpecializationEntity.builder()
                .id(specializationRequest.getId())
                .name(specializationRequest.getName())
                .build();
    }
}

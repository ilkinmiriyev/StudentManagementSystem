package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Specialization;
import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpecializationRequestConverter implements Function<SpecializationRequest, Specialization> {
    @Override
    public Specialization apply(SpecializationRequest specializationRequest) {
        return Specialization.builder()
                .id(specializationRequest.getId())
                .name(specializationRequest.getName())
                .build();
    }
}

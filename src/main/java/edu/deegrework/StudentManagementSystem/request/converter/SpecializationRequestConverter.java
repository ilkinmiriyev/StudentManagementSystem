package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.Specialization;
import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;

import java.util.function.Function;

public class SpecializationRequestConverter implements Function<SpecializationRequest, Specialization> {
    @Override
    public Specialization apply(SpecializationRequest specializationRequest) {
        return Specialization.builder()
                .id(specializationRequest.getId())
                .name(specializationRequest.getName())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.UniversityEntity;
import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityRequestConverter implements Function<UniversityRequest, UniversityEntity> {
    @Override
    public UniversityEntity apply(UniversityRequest universityRequest) {

        return UniversityEntity.builder()
                .id(universityRequest.getId())
                .name(universityRequest.getName())
                .build();
    }
}

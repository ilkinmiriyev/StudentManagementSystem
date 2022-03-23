package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityRequestConverter implements Function<UniversityRequest, University> {
    @Override
    public University apply(UniversityRequest universityRequest) {

        return University.builder()
                .id(universityRequest.getId())
                .name(universityRequest.getName())
                .build();
    }
}

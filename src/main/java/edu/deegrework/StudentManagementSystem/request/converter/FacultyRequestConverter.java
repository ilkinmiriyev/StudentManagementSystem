package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.FacultyEntity;
import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FacultyRequestConverter implements Function<FacultyRequest, FacultyEntity> {

    @Override
    public FacultyEntity apply(FacultyRequest facultyRequest) {

        return FacultyEntity.builder()
                .id(facultyRequest.getId())
                .name(facultyRequest.getName())
                .build();
    }
}

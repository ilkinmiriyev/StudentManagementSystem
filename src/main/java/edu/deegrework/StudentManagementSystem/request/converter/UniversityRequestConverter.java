package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.request.UniversityRequest;

import java.util.function.Function;

public class UniversityRequestConverter implements Function<UniversityRequest, University> {
    @Override
    public University apply(UniversityRequest universityRequest) {

        return University.builder()
                .id(universityRequest.getId())
                .name(universityRequest.getName())
                .build();
    }
}

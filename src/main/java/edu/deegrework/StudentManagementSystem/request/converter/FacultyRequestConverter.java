package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FacultyRequestConverter implements Function<FacultyRequest, Faculty> {

    @Override
    public Faculty apply(FacultyRequest facultyRequest) {

        return Faculty.builder()
                .id(facultyRequest.getId())
                .name(facultyRequest.getName())
                .build();
    }
}

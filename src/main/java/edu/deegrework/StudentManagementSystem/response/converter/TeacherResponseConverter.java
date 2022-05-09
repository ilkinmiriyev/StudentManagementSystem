package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Teacher;
import edu.deegrework.StudentManagementSystem.response.TeacherResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherResponseConverter implements Function<Teacher, TeacherResponse> {
    @Override
    public TeacherResponse apply(Teacher teacher) {
        return TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastname())
                .email(teacher.getUserDetails().getEmail())
                .role(teacher.getUserDetails().getRole())
                .subjectName(teacher.getSubject().getName())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentResponseConverter implements Function<StudentEntity, StudentResponse> {

    @Override
    public StudentResponse apply(StudentEntity student) {

        return StudentResponse.builder()
                .id(student.getId())
                .firstname(student.getFirstName())
                .lastname(student.getLastName())
                .birthdate(student.getBirthdate())
                .email(student.getUserDetails().getEmail())
                .role(student.getUserDetails().getRole())
                .phone(student.getPhone())
                .academicDegree(student.getAcademicDegree())
                .semester(student.getSemester())
                .build();
    }
}

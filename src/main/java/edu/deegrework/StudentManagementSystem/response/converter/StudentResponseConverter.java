package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.function.Function;

@Component
public class StudentResponseConverter implements Function<Student, StudentResponse> {

    @Override
    public StudentResponse apply(@Valid Student student) {

        return StudentResponse.builder()
                .id(student.getId())
                .firstname(student.getFirstName())
                .lastname(student.getLastName())
                .birthdate(student.getBirthdate())
                .email(student.getEmail())
                .phone(student.getPhone())
                .academicDegree(student.getAcademicDegree())
                .course(student.getCourse())
                .build();
    }
}

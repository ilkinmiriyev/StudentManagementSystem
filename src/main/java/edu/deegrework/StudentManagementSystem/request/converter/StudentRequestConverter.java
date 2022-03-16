package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentRequestConverter implements Function<StudentRequest, Student> {

    @Override
    public Student apply(StudentRequest studentRequest) {

        if (studentRequest == null) {
            return null;
        }

        return Student.builder()
                .academicDegree(studentRequest.getAcademicDegree())
                .birthdate(studentRequest.getBirthdate())
                .id(studentRequest.getId())
                .course(studentRequest.getCourse())
                .email(studentRequest.getEmail())
                .firstName(studentRequest.getFirstname())
                .phone(studentRequest.getPhone())
                .lastName(studentRequest.getLastname())
                .password(studentRequest.getPassword())
                .build();
    }
}

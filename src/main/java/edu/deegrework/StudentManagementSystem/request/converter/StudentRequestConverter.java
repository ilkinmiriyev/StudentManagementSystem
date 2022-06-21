package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.model.User;
import edu.deegrework.StudentManagementSystem.enumaration.Role;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentRequestConverter implements Function<StudentRequest, StudentEntity> {

    @Override
    public StudentEntity apply(StudentRequest studentRequest) {

        if (studentRequest == null) {
            return null;
        }

        User user = new User();
        user.setEmail(studentRequest.getEmail());
        user.setPassword(studentRequest.getPassword());
        user.setRole(Role.STUDENT);

        return StudentEntity.builder()
                .academicDegree(studentRequest.getAcademicDegree())
                .birthdate(studentRequest.getBirthdate())
                .id(studentRequest.getId())
                .semester(studentRequest.getSemester())
                .firstName(studentRequest.getFirstname())
                .phone(studentRequest.getPhone())
                .lastName(studentRequest.getLastname())

                .userDetails(user)
                .build();
    }
}

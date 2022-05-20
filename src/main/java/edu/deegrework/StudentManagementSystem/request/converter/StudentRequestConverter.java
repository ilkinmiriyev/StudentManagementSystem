package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import edu.deegrework.StudentManagementSystem.security.Role;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentRequestConverter implements Function<StudentRequest, StudentEntity> {

    @Override
    public StudentEntity apply(StudentRequest studentRequest) {

        if (studentRequest == null) {
            return null;
        }

        CustomUserDetails user = new CustomUserDetails();
        user.setEmail(studentRequest.getEmail());
        user.setPassword(studentRequest.getPassword());
        user.setRole(Role.STUDENT);
        return StudentEntity.builder()
                .academicDegree(studentRequest.getAcademicDegree())
                .birthdate(studentRequest.getBirthdate())
                .id(studentRequest.getId())
                .semester(studentRequest.getSemester())
//                .email(studentRequest.getEmail())
                .firstName(studentRequest.getFirstname())
                .phone(studentRequest.getPhone())
                .lastName(studentRequest.getLastname())
//                .password(studentRequest.getPassword())

                .userDetails(user)
                .build();
    }
}

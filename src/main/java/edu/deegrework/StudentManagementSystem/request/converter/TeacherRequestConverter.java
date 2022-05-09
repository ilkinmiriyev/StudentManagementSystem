package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Teacher;
import edu.deegrework.StudentManagementSystem.request.TeacherRequest;
import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import edu.deegrework.StudentManagementSystem.security.Role;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherRequestConverter implements Function<TeacherRequest, Teacher> {

    @Override
    public Teacher apply(TeacherRequest request) {

        if (request == null) {
            return null;
        }

        CustomUserDetails user = new CustomUserDetails();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.TEACHER);

        return Teacher.builder()
                .id(request.getId())
                .userDetails(user)
                .firstName(request.getFirstname())
                .lastname(request.getLastname())
                .build();
    }
}

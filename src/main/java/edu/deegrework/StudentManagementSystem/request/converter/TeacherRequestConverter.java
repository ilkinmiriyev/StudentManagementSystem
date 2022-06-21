package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.TeacherEntity;
import edu.deegrework.StudentManagementSystem.request.TeacherRequest;
import edu.deegrework.StudentManagementSystem.model.User;
import edu.deegrework.StudentManagementSystem.enumaration.Role;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherRequestConverter implements Function<TeacherRequest, TeacherEntity> {

    @Override
    public TeacherEntity apply(TeacherRequest request) {

        if (request == null) {
            return null;
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.TEACHER);

        return TeacherEntity.builder()
                .id(request.getId())
                .userDetails(user)
                .firstName(request.getFirstname())
                .lastname(request.getLastname())
                .build();
    }
}

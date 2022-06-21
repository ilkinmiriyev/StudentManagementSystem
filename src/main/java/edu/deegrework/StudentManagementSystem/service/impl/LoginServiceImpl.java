package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.model.TeacherEntity;
import edu.deegrework.StudentManagementSystem.repository.UserRepository;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeacherRepository;
import edu.deegrework.StudentManagementSystem.response.CustomUserDetailsResponse;
import edu.deegrework.StudentManagementSystem.response.converter.CustomUserDetailsResponseConverter;
import edu.deegrework.StudentManagementSystem.enumaration.Role;
import edu.deegrework.StudentManagementSystem.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final CustomUserDetailsResponseConverter userDetailsResponseConverter;

    @Override
    public CustomUserDetailsResponse successLogin() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        CustomUserDetailsResponse userResponse = userDetailsResponseConverter
                .apply(userRepository.findByEmail(email).get());
        if (userResponse.getRole() == Role.STUDENT) {
            StudentEntity student = studentRepository.findByUserDetails(userDetails).get();
            userResponse.setUserId(student.getId());
            userResponse.setFullName(student.getFirstName() + " " + student.getLastName());

        } else if (userResponse.getRole() == Role.TEACHER) {
            TeacherEntity teacher = teacherRepository.findByUserDetails(userDetails).get();
            userResponse.setUserId(teacher.getId());
            userResponse.setFullName(teacher.getFirstName() + " " + teacher.getLastname());
        }
        return userResponse;
    }
}

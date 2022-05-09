package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Teacher;
import edu.deegrework.StudentManagementSystem.repository.CustomUserDetailsRepository;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeacherRepository;
import edu.deegrework.StudentManagementSystem.response.CustomUserDetailsResponse;
import edu.deegrework.StudentManagementSystem.response.converter.CustomUserDetailsResponseConverter;
import edu.deegrework.StudentManagementSystem.security.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/")
public class LoginController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CustomUserDetailsRepository userRepository;
    private final CustomUserDetailsResponseConverter userDetailsResponseConverter;

    @GetMapping(path = "/successLogin")
    public CustomUserDetailsResponse login(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("ActionLog.login start");
        String email = userDetails.getUsername();
        CustomUserDetailsResponse userResponse = userDetailsResponseConverter
                .apply(userRepository.findByEmail(email).get());

        if (userResponse.getRole() == Role.STUDENT) {
            Student student = studentRepository.findByUserDetails(userDetails).get();
            userResponse.setUserId(student.getId());
            userResponse.setFullName(student.getFirstName()+" "+student.getLastName());

        } else if (userResponse.getRole() == Role.TEACHER) {
            Teacher teacher = teacherRepository.findByUserDetails(userDetails).get();
            userResponse.setUserId(teacher.getId());
            userResponse.setFullName(teacher.getFirstName()+" "+teacher.getLastname());
        }

        return userResponse;

/*
        StudentResponse studentResponse = responseConverter.apply(student);
        if (user.getLoggedIn()) {
            return studentResponse;
        } else {
            throw new IllegalArgumentException("Test"); // todo: message
        }*/
    }
}


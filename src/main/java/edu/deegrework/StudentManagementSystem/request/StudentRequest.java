package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.model.AcademicDegree;
import edu.deegrework.StudentManagementSystem.model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentRequest {

    private Long id;

    private String firstname;

    private String lastname;

    private Date birthdate;

    private String email;

    private String phone;

    private Long teamId;

    private String password;

    private AcademicDegree academicDegree;

    private Course course;



}

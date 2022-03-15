package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.model.AcademicDegree;
import edu.deegrework.StudentManagementSystem.model.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class StudentResponse {

    private Long id;

    private String firstname;

    private String lastname;

    private Date birthdate;

    private String email;

    private String phone;

    private Course course;

    private AcademicDegree academicDegree;

}

package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.model.AcademicDegree;
import edu.deegrework.StudentManagementSystem.model.Course;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class StudentRequest {

    private Long id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @NotNull
    private Date birthdate;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotNull
    private Long teamId;

    @NotEmpty
    private String password;

    private AcademicDegree academicDegree;

    private Course course;
}

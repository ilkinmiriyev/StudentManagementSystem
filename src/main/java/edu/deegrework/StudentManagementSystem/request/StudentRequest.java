package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.enumaration.AcademicDegree;
import edu.deegrework.StudentManagementSystem.enumaration.Semester;
import edu.deegrework.StudentManagementSystem.validation.PhoneValidation;
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
    @PhoneValidation
    private String phone;
    @NotNull
    private Long teamId;
    @NotEmpty
    private String password;
    private AcademicDegree academicDegree;
    private Semester semester;
}

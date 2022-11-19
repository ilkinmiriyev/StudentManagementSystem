package edu.deegrework.StudentManagementSystem.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.deegrework.StudentManagementSystem.enumaration.AcademicDegree;
import edu.deegrework.StudentManagementSystem.enumaration.Semester;
import edu.deegrework.StudentManagementSystem.enumaration.Role;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthdate;
    private String email;
    private String phone;
    private Semester semester;
    private Role role;
    private AcademicDegree academicDegree;
    private String teamName;
}

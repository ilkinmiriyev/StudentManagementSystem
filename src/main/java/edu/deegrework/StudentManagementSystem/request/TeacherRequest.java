package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TeacherRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Long subjectId;
    private List<Long> teamsId;
}

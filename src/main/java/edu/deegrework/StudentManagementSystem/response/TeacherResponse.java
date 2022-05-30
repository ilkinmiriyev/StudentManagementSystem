package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.security.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class  TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String subjectName;
}

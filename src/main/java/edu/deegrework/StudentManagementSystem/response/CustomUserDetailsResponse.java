package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.enumaration.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CustomUserDetailsResponse {
    private Long id;
    private String fullName;
    private Long userId;
    private Role role;
}

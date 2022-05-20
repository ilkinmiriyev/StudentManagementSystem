package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacultyRequest {
    private Long id;
    private String name;
    private Long universityId;
}

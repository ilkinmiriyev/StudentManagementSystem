package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequest {
    private Long id;
    private String name;
    private Long specializationId;
}

package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.model.Specialization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequest {

    private Long id;
    private String name;
    private Long specializationId;
}

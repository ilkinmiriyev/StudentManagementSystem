package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecializationRequest {

    private Long id;
    private String name;
    private Long facultyId;
}

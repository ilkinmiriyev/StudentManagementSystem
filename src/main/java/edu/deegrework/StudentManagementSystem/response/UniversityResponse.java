package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.model.AcademicDegree;
import edu.deegrework.StudentManagementSystem.model.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter
public class UniversityResponse {

    private Long id;

    private String name;

//    private List<FacultyResponse> facultyResponses;
}

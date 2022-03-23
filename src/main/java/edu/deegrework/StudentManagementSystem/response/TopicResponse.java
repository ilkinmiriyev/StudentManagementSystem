package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.model.AcademicDegree;
import edu.deegrework.StudentManagementSystem.model.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class TopicResponse {

    private Long id;

    private String name;
}

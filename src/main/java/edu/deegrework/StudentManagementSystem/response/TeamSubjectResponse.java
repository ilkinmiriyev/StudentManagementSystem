package edu.deegrework.StudentManagementSystem.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TeamSubjectResponse {
    private Long subjectId;
    private String subjectName;
    private List<TeamResponse> teams;
}

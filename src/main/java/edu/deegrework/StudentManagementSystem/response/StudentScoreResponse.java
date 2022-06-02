package edu.deegrework.StudentManagementSystem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class StudentScoreResponse {
    private Long studentId;
    private String firstName;
    private String lastName;
    private List<ScoreResponse> scores;
}

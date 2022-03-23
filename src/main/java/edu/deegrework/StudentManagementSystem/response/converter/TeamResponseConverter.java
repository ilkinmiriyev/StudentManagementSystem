package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TeamResponseConverter implements Function<Team, TeamResponse> {

    @Override
    public TeamResponse apply(Team team) {

        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
//                .students(team.getStudents()
//                        .stream()
//                        .map(student -> new StudentResponseConverter().apply(student))
//                        .collect(Collectors.toList()))
//                .subjectResponses(team.getSubjects()
//                        .stream()
//                        .map(subject -> new SubjectResponseConverter().apply(subject))
//                        .collect(Collectors.toList()))
                .build();
    }
}

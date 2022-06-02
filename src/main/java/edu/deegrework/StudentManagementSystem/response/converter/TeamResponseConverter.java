package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamResponseConverter implements Function<TeamEntity, TeamResponse> {

    @Override
    public TeamResponse apply(TeamEntity team) {

        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamRequestConverter implements Function<TeamRequest, Team> {
    @Override
    public Team apply(TeamRequest teamRequest) {
        return Team.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .build();
    }
}

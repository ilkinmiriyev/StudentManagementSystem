package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeamRequestConverter implements Function<TeamRequest, TeamEntity> {
    @Override
    public TeamEntity apply(TeamRequest teamRequest) {
        return TeamEntity.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .build();
    }
}

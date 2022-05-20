package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.SpecializationEntity;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpecializationResponseConverter implements Function<SpecializationEntity, SpecializationResponse> {

    @Override
    public SpecializationResponse apply(SpecializationEntity specialization) {

        return SpecializationResponse.builder()
                .id(specialization.getId())
                .name(specialization.getName())
//                .teamResponses(specialization.getTeams()
//                        .stream()
//                        .map(team -> new TeamResponseConverter().apply(team))
//                        .collect(Collectors.toList()))
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Specialization;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SpecializationResponseConverter implements Function<Specialization, SpecializationResponse> {

    @Override
    public SpecializationResponse apply(Specialization specialization) {

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

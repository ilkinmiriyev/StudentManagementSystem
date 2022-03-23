package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FacultyResponseConverter implements Function<Faculty, FacultyResponse> {

    @Override
    public FacultyResponse apply(Faculty faculty) {

        return FacultyResponse.builder()
                .id(faculty.getId())
                .name(faculty.getName())
//                .specializationResponses(faculty.getSpecializations()
//                        .stream()
//                        .map(specialization -> new SpecializationResponseConverter().apply(specialization))
//                        .collect(Collectors.toList()))
                .build();
    }
}

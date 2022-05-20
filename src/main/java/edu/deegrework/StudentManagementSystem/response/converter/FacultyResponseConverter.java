package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.FacultyEntity;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FacultyResponseConverter implements Function<FacultyEntity, FacultyResponse> {

    @Override
    public FacultyResponse apply(FacultyEntity faculty) {

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

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.UniversityEntity;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityResponseConverter implements Function<UniversityEntity, UniversityResponse> {

    @Override
    public UniversityResponse apply(UniversityEntity university) {
        return UniversityResponse.builder()
                .id(university.getId())
                .name(university.getName())
                .build();
    }
}

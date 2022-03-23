package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UniversityResponseConverter implements Function<University, UniversityResponse> {

    @Override
    public UniversityResponse apply(University university) {
        return UniversityResponse.builder()
                .id(university.getId())
                .name(university.getName())
//                .facultyResponses(university.getFaculties()
//                        .stream()`
//                        .map(faculty -> new FacultyResponseConverter().apply(faculty))
//                        .collect(Collectors.toList()))
                .build();
    }
}

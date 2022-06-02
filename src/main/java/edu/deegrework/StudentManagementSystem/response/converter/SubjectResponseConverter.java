package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubjectResponseConverter implements Function<SubjectEntity, SubjectResponse> {

    @Override
    public SubjectResponse apply(SubjectEntity subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }
}

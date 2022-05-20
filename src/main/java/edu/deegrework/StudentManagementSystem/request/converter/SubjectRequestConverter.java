package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubjectRequestConverter implements Function<SubjectRequest, SubjectEntity> {
    @Override
    public SubjectEntity apply(SubjectRequest subjectRequest) {
        return SubjectEntity.builder()
                .id(subjectRequest.getId())
                .name(subjectRequest.getName())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Subject;
import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubjectRequestConverter implements Function<SubjectRequest, Subject> {
    @Override
    public Subject apply(SubjectRequest subjectRequest) {
        return Subject.builder()
                .id(subjectRequest.getId())
                .name(subjectRequest.getName())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Subject;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SubjectResponseConverter implements Function<Subject, SubjectResponse> {

    @Override
    public SubjectResponse apply(Subject subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
//                .topicResponses(subject.getTopics()
//                        .stream()
//                        .map(topic -> new TopicResponseConverter().apply(topic))
//                        .collect(Collectors.toList()))
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Topic;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TopicResponseConverter implements Function<Topic, TopicResponse> {

    @Override
    public TopicResponse apply(Topic topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }
}

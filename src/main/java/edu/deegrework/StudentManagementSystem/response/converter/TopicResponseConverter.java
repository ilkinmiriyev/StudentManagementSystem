package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.TopicEntity;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TopicResponseConverter implements Function<TopicEntity, TopicResponse> {

    @Override
    public TopicResponse apply(TopicEntity topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }
}

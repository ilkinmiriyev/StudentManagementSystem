package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.TopicEntity;
import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TopicRequestConverter implements Function<TopicRequest, TopicEntity> {
    @Override
    public TopicEntity apply(TopicRequest topicRequest) {
        return TopicEntity.builder()
                .id(topicRequest.getId())
                .name(topicRequest.getName())
                .build();
    }
}

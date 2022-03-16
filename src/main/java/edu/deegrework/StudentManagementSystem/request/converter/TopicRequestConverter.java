package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.model.Topic;
import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.request.TopicRequest;

import java.util.function.Function;

public class TopicRequestConverter implements Function<TopicRequest, Topic> {
    @Override
    public Topic apply(TopicRequest topicRequest) {
        return Topic.builder()
                .id(topicRequest.getId())
                .name(topicRequest.getName())
                .build();
    }
}

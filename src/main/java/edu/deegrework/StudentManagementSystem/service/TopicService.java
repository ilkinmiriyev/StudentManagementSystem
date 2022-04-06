package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;

import java.util.List;

public interface TopicService {

    TopicResponse getTopic(Long id);

    List<TopicResponse> getTopics();

    TopicResponse save(TopicRequest topicRequest);

    TopicResponse update(Long id, TopicRequest topicRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

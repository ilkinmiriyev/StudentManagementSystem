package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;

import java.util.List;

public interface TopicService {

    TopicResponse getById(Long id);

    List<TopicResponse> getAll();

    TopicResponse save(TopicRequest topicRequest);

    TopicResponse update(Long id, TopicRequest topicRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

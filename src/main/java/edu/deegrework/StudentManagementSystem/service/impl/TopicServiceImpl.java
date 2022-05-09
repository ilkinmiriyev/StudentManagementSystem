package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Subject;
import edu.deegrework.StudentManagementSystem.model.Topic;
import edu.deegrework.StudentManagementSystem.repository.SubjectRepository;
import edu.deegrework.StudentManagementSystem.repository.TopicRepository;
import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import edu.deegrework.StudentManagementSystem.request.converter.TopicRequestConverter;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;
import edu.deegrework.StudentManagementSystem.response.converter.TopicResponseConverter;
import edu.deegrework.StudentManagementSystem.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;
    private final TopicRequestConverter requestConverter;
    private final TopicResponseConverter responseConverter;

    @Override
    public TopicResponse getTopic(Long id) {
        return topicRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Topic not found with id: " + id));
    }

    @Override
    public List<TopicResponse> getTopics() {
        return topicRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse save(TopicRequest topicRequest) {
        Subject subject = subjectRepository
                .findById(topicRequest.getSubjectId())
                .orElseThrow(() -> new RecordNotFoundException("Subject not found with id: " + topicRequest.getSubjectId()));
        Topic topic = requestConverter.apply(topicRequest);
        topic.setSubject(subject);
        return responseConverter.apply(topicRepository.save(topic));
    }

    @Override
    public TopicResponse update(Long id, TopicRequest topicRequest) {
        if (existsById(id)) {
            topicRequest.setId(id);
            return save(topicRequest);
        } else {
            throw new RecordNotFoundException("Topic not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return topicRepository.existsById(id);
    }
}

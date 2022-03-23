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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final SubjectRepository subjectRepository;
    private final TopicRequestConverter requestConverter;
    private final TopicResponseConverter responseConverter;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository,
                            SubjectRepository subjectRepository,
                            TopicRequestConverter requestConverter,
                            TopicResponseConverter responseConverter) {
        this.topicRepository = topicRepository;
        this.subjectRepository = subjectRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
    }


    @Override
    public TopicResponse getById(Long id) {
        return topicRepository.findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("Topic not found this id :: " + id));
    }

    @Override
    public List<TopicResponse> getAll() {
        return topicRepository
                .findAll()
                .stream()
                .map(responseConverter::apply)
                .collect(Collectors.toList());
    }

    @Override
    public TopicResponse save(TopicRequest topicRequest) {
        Subject subject = subjectRepository
                .findById(topicRequest.getSubjectId())
                .orElseThrow(() -> new RecordNotFoundException("Subject not found this id :: " + topicRequest.getSubjectId()));
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
            throw new RecordNotFoundException("Topic not found this id :: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return topicRepository.existsById(id);
    }
}

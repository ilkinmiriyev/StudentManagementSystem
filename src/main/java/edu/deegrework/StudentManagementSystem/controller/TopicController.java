package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;
import edu.deegrework.StudentManagementSystem.response.converter.TopicResponseConverter;
import edu.deegrework.StudentManagementSystem.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/topic", produces = "application/json")
public class TopicController {

    private final TopicService topicService;
    private final TopicResponseConverter converter;

    @Autowired
    public TopicController(TopicService topicService,
                           TopicResponseConverter converter) {
        this.topicService = topicService;
        this.converter = converter;
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable Long topicId) {
        TopicResponse topicResponse = topicService.getById(topicId);
        return new ResponseEntity<>(topicResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAll() {
        List<TopicResponse> topicResponses = topicService.getAll();
        return new ResponseEntity<>(topicResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TopicResponse> save(@RequestBody TopicRequest topicRequest) {
        TopicResponse topicResponse = topicService.save(topicRequest);
        return new ResponseEntity<>(topicResponse, HttpStatus.OK);
    }

    @PutMapping("/{topicId}")
    public ResponseEntity<TopicResponse> update(@PathVariable Long topicId,
                                                     @RequestBody TopicRequest topicRequest) {
        TopicResponse topicResponse = topicService.update(topicId, topicRequest);
        return new ResponseEntity<>(topicResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<TopicResponse> deleteById(@PathVariable Long topicId) {
        topicService.deleteById(topicId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

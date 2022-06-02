package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.TopicRequest;
import edu.deegrework.StudentManagementSystem.response.TopicResponse;
import edu.deegrework.StudentManagementSystem.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/v1/topics", produces = "application/json")
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TopicResponse getTopic(@PathVariable Long id) {
        return topicService.getTopic(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TopicResponse> getTopics() {
        return topicService.getTopics();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicResponse save(@RequestBody TopicRequest topicRequest) {
        return topicService.save(topicRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TopicResponse update(@PathVariable Long id,
                                @RequestBody TopicRequest topicRequest) {
        return topicService.update(id, topicRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }
}

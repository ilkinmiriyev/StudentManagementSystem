package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import edu.deegrework.StudentManagementSystem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/v1/subjects", produces = "application/json")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectResponse getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectResponse> getSubjects() {
        return subjectService.getSubjects();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectResponse save(@RequestBody SubjectRequest subjectRequest) {
        return subjectService.save(subjectRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectResponse update(@PathVariable Long id,
                                  @RequestBody SubjectRequest subjectRequest) {
        return subjectService.update(id, subjectRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}

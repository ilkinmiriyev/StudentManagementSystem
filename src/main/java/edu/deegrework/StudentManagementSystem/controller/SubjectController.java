package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SubjectResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/subject", produces = "application/json")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectResponseConverter converter;

    @Autowired
    public SubjectController(SubjectService subjectService,
                             SubjectResponseConverter converter) {
        this.subjectService = subjectService;
        this.converter = converter;
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectResponse> getSubjectById(@PathVariable Long subjectId) {
        SubjectResponse subjectResponse = subjectService.getById(subjectId);
        return new ResponseEntity<>(subjectResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponse>> getAll() {
        List<SubjectResponse> subjectResponses = subjectService.getAll();
        return new ResponseEntity<>(subjectResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectResponse> save(@RequestBody SubjectRequest subjectRequest) {
        SubjectResponse subjectResponse = subjectService.save(subjectRequest);
        return new ResponseEntity<>(subjectResponse, HttpStatus.OK);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<SubjectResponse> update(@PathVariable Long subjectId,
                                                  @RequestBody SubjectRequest subjectRequest) {
        SubjectResponse subjectResponse = subjectService.update(subjectId, subjectRequest);
        return new ResponseEntity<>(subjectResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<SubjectResponse> deleteById(@PathVariable Long subjectId) {
        subjectService.deleteById(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

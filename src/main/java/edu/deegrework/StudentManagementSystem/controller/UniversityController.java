package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/university", produces = "application/json")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{universityId}")
    public ResponseEntity<UniversityResponse> getUniversityById(@PathVariable Long universityId) {
        UniversityResponse universityResponse = universityService.getById(universityId);
        return new ResponseEntity<>(universityResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UniversityResponse>> getAll() {
        List<UniversityResponse> universityResponses = universityService.getAll();
        return new ResponseEntity<>(universityResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UniversityResponse> save(@RequestBody UniversityRequest universityRequest) {
        UniversityResponse universityResponse = universityService.save(universityRequest);
        return new ResponseEntity<>(universityResponse, HttpStatus.OK);
    }

    @PutMapping("/{universityId}")
    public ResponseEntity<UniversityResponse> update(@PathVariable Long universityId,
                                                     @RequestBody UniversityRequest universityRequest) {
        UniversityResponse universityResponse = universityService.update(universityId, universityRequest);
        return new ResponseEntity<>(universityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{universityId}")
    public ResponseEntity<UniversityResponse> deleteById(@PathVariable Long universityId) {
        universityService.deleteById(universityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

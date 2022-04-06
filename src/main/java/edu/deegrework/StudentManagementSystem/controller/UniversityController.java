package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/university", produces = "application/json")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{id}")
    public UniversityResponse v(@PathVariable Long id) {
        return universityService.getUniversity(id);
    }

    @GetMapping
    public List<UniversityResponse> getUniversities() {
        return universityService.getUniversities();
    }

    @PostMapping
    public UniversityResponse save(@RequestBody UniversityRequest universityRequest) {
        return universityService.save(universityRequest);
    }

    @PutMapping("/{id}")
    public UniversityResponse update(@PathVariable Long id,
                                     @RequestBody UniversityRequest universityRequest) {
        return universityService.update(id, universityRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        universityService.delete(id);
    }
}

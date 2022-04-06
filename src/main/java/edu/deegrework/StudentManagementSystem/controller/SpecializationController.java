package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import edu.deegrework.StudentManagementSystem.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/specialization", produces = "application/json")
public class SpecializationController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpecializationResponse getSpecializationById(@PathVariable Long id) {
        return specializationService.getSpecialization(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SpecializationResponse> getSpecializations() {
        return specializationService.getSpecializations();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpecializationResponse save(@RequestBody SpecializationRequest specializationRequest) {
        return specializationService.save(specializationRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpecializationResponse update(@PathVariable Long id,
                                         @RequestBody SpecializationRequest specializationRequest) {
        return specializationService.update(id, specializationRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        specializationService.delete(id);
    }
}

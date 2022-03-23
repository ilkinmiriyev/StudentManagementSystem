package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SpecializationResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/specialization", produces = "application/json")
public class SpecializationController {

    private final SpecializationService specializationService;
    private final SpecializationResponseConverter responseConverter;

    @Autowired
    public SpecializationController(SpecializationService specializationService,
                                    SpecializationResponseConverter responseConverter) {
        this.specializationService = specializationService;
        this.responseConverter = responseConverter;
    }

    @GetMapping("/{specializationId}")
    public ResponseEntity<SpecializationResponse> getSpecializationById(@PathVariable Long specializationId) {
        SpecializationResponse specializationResponse = specializationService.getById(specializationId);
        return new ResponseEntity<>(specializationResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SpecializationResponse>> getAll() {
        List<SpecializationResponse> specializationResponses = specializationService.getAll();
        return new ResponseEntity<>(specializationResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SpecializationResponse> save(@RequestBody SpecializationRequest specializationRequest) {
        SpecializationResponse specializationResponse = specializationService.save(specializationRequest);
        return new ResponseEntity<>(specializationResponse, HttpStatus.OK);
    }

    @PutMapping("/{specializationId}")
    public ResponseEntity<SpecializationResponse> update(@PathVariable Long specializationId,
                                                         @RequestBody SpecializationRequest specializationRequest) {
        SpecializationResponse specializationResponse = specializationService.update(specializationId, specializationRequest);
        return new ResponseEntity<>(specializationResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{specializationId}")
    public ResponseEntity<SpecializationResponse> deleteById(@PathVariable Long specializationId) {
        specializationService.deleteById(specializationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

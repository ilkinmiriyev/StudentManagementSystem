package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import edu.deegrework.StudentManagementSystem.response.converter.FacultyResponseConverter;
import edu.deegrework.StudentManagementSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/faculty", produces = "application/json")
public class FacultyController {

    private final FacultyService facultyService;
    private final FacultyResponseConverter responseConverter;

    @Autowired
    public FacultyController(FacultyService facultyService,
                             FacultyResponseConverter responseConverter) {
        this.facultyService = facultyService;
        this.responseConverter = responseConverter;
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> getFacultyById(@PathVariable Long facultyId) {
        FacultyResponse facultyResponse = facultyService.getById(facultyId);
        return new ResponseEntity<>(facultyResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponse>> getAll() {
        List<FacultyResponse> facultyResponses = facultyService.getAll();
        return new ResponseEntity<>(facultyResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FacultyResponse> save(@RequestBody FacultyRequest facultyRequest) {
        FacultyResponse facultyResponse = facultyService.save(facultyRequest);
        return new ResponseEntity<>(facultyResponse, HttpStatus.OK);
    }

    @PutMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> update(@PathVariable Long facultyId,
                                                  @RequestBody FacultyRequest facultyRequest) {
        FacultyResponse facultyResponse = facultyService.update(facultyId, facultyRequest);
        return new ResponseEntity<>(facultyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> deleteById(@PathVariable Long facultyId) {
        facultyService.deleteById(facultyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

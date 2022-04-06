package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import edu.deegrework.StudentManagementSystem.response.converter.FacultyResponseConverter;
import edu.deegrework.StudentManagementSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/faculties", produces = "application/json")
public class FacultyController {

    private final FacultyService facultyService;
    private final FacultyResponseConverter responseConverter;

    @Autowired
    public FacultyController(FacultyService facultyService,
                             FacultyResponseConverter responseConverter) {
        this.facultyService = facultyService;
        this.responseConverter = responseConverter;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FacultyResponse getFaculty(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FacultyResponse> getFaculties() {
        return facultyService.getFaculties();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FacultyResponse save(@RequestBody FacultyRequest facultyRequest) {
        return facultyService.save(facultyRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FacultyResponse update(@PathVariable Long id,
                                  @RequestBody FacultyRequest facultyRequest) {
        return facultyService.update(id, facultyRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facultyService.delete(id);
    }
}

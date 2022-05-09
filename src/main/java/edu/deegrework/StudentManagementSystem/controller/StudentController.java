package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.email.EmailSender;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1/students", produces = "application/json")
public class StudentController {

    private final EmailSender emailSender;
    private final StudentService studentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@Valid @RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse update(@PathVariable Long id,
                                  @RequestBody @Valid StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}

package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.excel.StudentExcelGeneratorService;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "/v1/students", produces = "application/json")
public class StudentController {

    private final StudentService studentService;
    private final StudentExcelGeneratorService excelService;

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

    @GetMapping("team-id")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudentsByTeamId(@RequestParam(name = "teamId") Long teamId) {
         return studentService.getStudentsByTeamId(teamId);
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

    @GetMapping("/excel")
    public ResponseEntity<ByteArrayResource> generate() throws IOException {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Students.xlsx");
        return new ResponseEntity<>(excelService.generate(), header, HttpStatus.CREATED);
    }
}

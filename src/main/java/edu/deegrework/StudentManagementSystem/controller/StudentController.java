package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.request.StudentRequestConverter;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.StudentResponseConverter;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/api/student", produces = "application/json")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long studentId){
        Student student = studentService.getById(studentId);
        StudentResponse studentResponse = new StudentResponseConverter().apply(student);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll(){
        List<StudentResponse> studentResponses = studentService
                .getAll().stream()
                .map(student -> new StudentResponseConverter().apply(student))
                .collect(Collectors.toList());
        return new ResponseEntity<>(studentResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest studentRequest){
        Student student = new StudentRequestConverter().apply(studentRequest);
        Student save = studentService.save(student);
        StudentResponse studentResponse = new StudentResponseConverter().apply(save);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long studentId,
                                                  @RequestBody StudentRequest studentRequest){
        if (studentService.existsById(studentId)){
            studentRequest.setId(studentId);
            Student student = new StudentRequestConverter().apply(studentRequest);
            Student save = studentService.save(student);
            StudentResponse studentResponse = new StudentResponseConverter().apply(save);
            return new ResponseEntity<>(studentResponse, HttpStatus.OK );
        }else{
            throw new RecordNotFoundException("Record not found this id :: "+studentId);
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentResponse> deleteById(@PathVariable Long studentId){
        studentService.deleteById(studentId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}

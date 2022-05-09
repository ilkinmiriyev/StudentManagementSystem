package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.TeacherRequest;
import edu.deegrework.StudentManagementSystem.response.TeacherResponse;
import edu.deegrework.StudentManagementSystem.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/teachers", produces = "application/json")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse getTeacher(@PathVariable Long id){
        return teacherService.getTeacher(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherResponse> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse save(@RequestBody TeacherRequest request){
        return teacherService.save(request);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse update(@PathVariable Long id,
                                  @RequestBody TeacherRequest request){
        return teacherService.update(id, request);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        teacherService.delete(id);
    }
}

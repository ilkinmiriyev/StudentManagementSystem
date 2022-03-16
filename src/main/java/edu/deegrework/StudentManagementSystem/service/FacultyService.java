package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;

import java.util.List;

public interface FacultyService {

    Faculty getById(Long id);

    List<Faculty> getAll();

    StudentResponse save(StudentRequest studentRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

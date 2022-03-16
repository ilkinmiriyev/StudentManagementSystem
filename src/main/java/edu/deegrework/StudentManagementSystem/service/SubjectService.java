package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;

import java.util.List;

public interface SubjectService {

    Student getById(Long id);

    List<Student> getAll();

    StudentResponse save(StudentRequest studentRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

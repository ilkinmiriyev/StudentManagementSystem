package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse getStudent(Long id);

    List<StudentResponse> getStudents();

    List<StudentResponse> getStudentsByTeamId(Long teamId);

    StudentResponse save(StudentRequest studentRequest);

    StudentResponse update(Long id, StudentRequest studentRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

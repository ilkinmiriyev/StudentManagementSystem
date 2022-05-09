package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.TeacherRequest;
import edu.deegrework.StudentManagementSystem.response.TeacherResponse;

import java.util.List;

public interface TeacherService {

    TeacherResponse getTeacher(Long id);

    List<TeacherResponse> getTeachers();

    TeacherResponse save(TeacherRequest request);

    TeacherResponse update(Long id, TeacherRequest request);

    void delete(Long id);

    boolean existsById(Long id);
}

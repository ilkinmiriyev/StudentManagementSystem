package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;

import java.util.List;

public interface FacultyService {

    FacultyResponse getFaculty(Long id);

    List<FacultyResponse> getFaculties();

    FacultyResponse save(FacultyRequest facultyRequest);

    FacultyResponse update(Long id, FacultyRequest facultyRequest);

    void delete(Long id);

    boolean existsById(Long id);
}

package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;

import java.util.List;

public interface FacultyService {

    FacultyResponse getById(Long id);

    List<FacultyResponse> getAll();

    FacultyResponse save(FacultyRequest facultyRequest);

    FacultyResponse update(Long id, FacultyRequest facultyRequest);

    void deleteById(Long id);

    boolean existsById(Long id);
}

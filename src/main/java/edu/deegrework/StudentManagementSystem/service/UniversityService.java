package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;

import java.util.List;

public interface UniversityService {

    UniversityResponse getById(Long id);

    List<UniversityResponse> getAll();

    UniversityResponse save(UniversityRequest university);

    UniversityResponse update(Long id, UniversityRequest universityRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

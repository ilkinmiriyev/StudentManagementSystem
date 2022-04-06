package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;

import java.util.List;

public interface UniversityService {

    UniversityResponse getUniversity(Long id);

    List<UniversityResponse> getUniversities();

    UniversityResponse save(UniversityRequest university);

    UniversityResponse update(Long id, UniversityRequest universityRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

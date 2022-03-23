package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;

import java.util.List;

public interface SpecializationService {

    SpecializationResponse getById(Long id);

    List<SpecializationResponse> getAll();

    SpecializationResponse save(SpecializationRequest specializationRequest);

    SpecializationResponse update(Long id, SpecializationRequest specializationRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

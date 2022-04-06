package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;

import java.util.List;

public interface SpecializationService {

    SpecializationResponse getSpecialization(Long id);

    List<SpecializationResponse> getSpecializations();

    SpecializationResponse save(SpecializationRequest specializationRequest);

    SpecializationResponse update(Long id, SpecializationRequest specializationRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.FacultyEntity;
import edu.deegrework.StudentManagementSystem.model.SpecializationEntity;
import edu.deegrework.StudentManagementSystem.repository.FacultyRepository;
import edu.deegrework.StudentManagementSystem.repository.SpecializationRepository;
import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.request.converter.SpecializationRequestConverter;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SpecializationResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SpecializationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final FacultyRepository facultyRepository;
    private final SpecializationRequestConverter requestConverter;
    private final SpecializationResponseConverter responseConverter;

    @Override
    public SpecializationResponse getSpecialization(Long id) {
        return specializationRepository
                .findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Specialization not found with id:" + id));
    }

    @Override
    public List<SpecializationResponse> getSpecializations() {
        return specializationRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public SpecializationResponse save(SpecializationRequest specializationRequest) {
        FacultyEntity faculty = facultyRepository.findById(specializationRequest.getFacultyId())
                .orElseThrow(()->new RecordNotFoundException("Faculty not found with id:"+specializationRequest.getFacultyId()));
        SpecializationEntity specialization = requestConverter.apply(specializationRequest);
        specialization.setFaculty(faculty);
        SpecializationEntity save = specializationRepository.save(specialization);
        return responseConverter.apply(save);
    }

    @Override
    public SpecializationResponse update(Long id, SpecializationRequest specializationRequest) {
        if (existsById(id)) {
            specializationRequest.setId(id);
            return save(specializationRequest);
        } else {
            throw new RecordNotFoundException("Specialization not found with id:" + id);
        }
    }

    @Override
    public void delete(Long id) {
        specializationRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return specializationRepository.existsById(id);
    }
}

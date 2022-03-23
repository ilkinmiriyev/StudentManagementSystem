package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.Specialization;
import edu.deegrework.StudentManagementSystem.repository.FacultyRepository;
import edu.deegrework.StudentManagementSystem.repository.SpecializationRepository;
import edu.deegrework.StudentManagementSystem.request.SpecializationRequest;
import edu.deegrework.StudentManagementSystem.request.converter.SpecializationRequestConverter;
import edu.deegrework.StudentManagementSystem.response.SpecializationResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SpecializationResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SpecializationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final FacultyRepository facultyRepository;
    private final SpecializationRequestConverter requestConverter;
    private final SpecializationResponseConverter responseConverter;

    public SpecializationServiceImpl(SpecializationRepository specializationRepository,
                                     FacultyRepository facultyRepository,
                                     SpecializationRequestConverter requestConverter,
                                     SpecializationResponseConverter responseConverter) {
        this.specializationRepository = specializationRepository;
        this.facultyRepository = facultyRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
    }

    @Override
    public SpecializationResponse getById(Long id) {
        return specializationRepository
                .findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("Specialization not found this id ::" + id));
    }

    @Override
    public List<SpecializationResponse> getAll() {
        return specializationRepository
                .findAll()
                .stream()
                .map(responseConverter::apply)
                .collect(Collectors.toList());
    }

    @Override
    public SpecializationResponse save(SpecializationRequest specializationRequest) {
        Faculty faculty = facultyRepository.findById(specializationRequest.getFacultyId())
                .orElseThrow(()->new RecordNotFoundException("Faculty not found this id ::"+specializationRequest.getFacultyId()));
        Specialization specialization = requestConverter.apply(specializationRequest);
        specialization.setFaculty(faculty);
        Specialization save = specializationRepository.save(specialization);
        return responseConverter.apply(save);
    }

    @Override
    public SpecializationResponse update(Long id, SpecializationRequest specializationRequest) {
        if (existsById(id)) {
            specializationRequest.setId(id);
            return save(specializationRequest);
        } else {
            throw new RecordNotFoundException("Specialization not found this id ::" + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        specializationRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return specializationRepository.existsById(id);
    }
}

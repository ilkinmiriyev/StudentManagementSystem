package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.repository.UniversityRepository;
import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.request.converter.UniversityRequestConverter;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import edu.deegrework.StudentManagementSystem.response.converter.UniversityResponseConverter;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityRequestConverter requestConverter;
    private final UniversityResponseConverter responseConverter;

    public UniversityResponse getUniversity(Long id) {
        return universityRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("University not found with id: " + id));
    }

    @Override
    public List<UniversityResponse> getUniversities() {
        return universityRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public UniversityResponse save(UniversityRequest universityRequest) {
        University university = requestConverter.apply(universityRequest);
        return responseConverter.apply(universityRepository.save(university));
    }

    @Override
    public UniversityResponse update(Long id, UniversityRequest universityRequest) {
        if (existsById(id)) {
            universityRequest.setId(id);
            return save(universityRequest);
        } else {
            throw new RecordNotFoundException("University not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        universityRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return universityRepository.existsById(id);
    }
}

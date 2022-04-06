package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.repository.UniversityRepository;
import edu.deegrework.StudentManagementSystem.request.UniversityRequest;
import edu.deegrework.StudentManagementSystem.request.converter.UniversityRequestConverter;
import edu.deegrework.StudentManagementSystem.response.UniversityResponse;
import edu.deegrework.StudentManagementSystem.response.converter.UniversityResponseConverter;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@DynamicUpdate
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityRequestConverter requestConverter;
    private final UniversityResponseConverter responseConverter;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository,
                                 UniversityRequestConverter requestConverter,
                                 UniversityResponseConverter responseConverter) {
        this.universityRepository = universityRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
    }

    public UniversityResponse getUniversity(Long id) {
        return universityRepository.findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("University not found this id :: " + id));
    }

    @Override
    public List<UniversityResponse> getUniversities() {
        return universityRepository
                .findAll()
                .stream()
                .map(responseConverter::apply)
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
            throw new RecordNotFoundException("University not found this id :: " + id);
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

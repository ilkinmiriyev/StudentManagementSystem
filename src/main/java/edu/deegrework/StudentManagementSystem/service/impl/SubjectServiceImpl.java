package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.SpecializationEntity;
import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.repository.SpecializationRepository;
import edu.deegrework.StudentManagementSystem.repository.SubjectRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.request.converter.SubjectRequestConverter;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SubjectResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final TeamRepository teamRepository;
    private final SubjectRequestConverter requestConverter;
    private final SubjectResponseConverter responseConverter;
    private final SpecializationRepository specializationRepository;

    @Override
    public SubjectResponse getSubject(Long id) {
        return subjectRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Subject not found with id:" + id));
    }

    @Override
    public List<SubjectResponse> getSubjects() {
        return subjectRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectResponse save(SubjectRequest subjectRequest) {
        List<SpecializationEntity> specializations = subjectRequest.getSpecializationsId()
                .stream()
                .map(specializationRepository::getById)
                .collect(Collectors.toList());
        SubjectEntity subject = requestConverter.apply(subjectRequest);
        subject.setSpecializations(specializations);
        return responseConverter.apply(subjectRepository.save(subject));
    }

    @Override
    public SubjectResponse update(Long id, SubjectRequest subjectRequest) {
        if (existsById(id)) {
            subjectRequest.setId(id);
            return save(subjectRequest);
        } else {
            throw new RecordNotFoundException("Subject not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return subjectRepository.existsById(id);
    }
}

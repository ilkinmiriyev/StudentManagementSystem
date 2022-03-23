package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Specialization;
import edu.deegrework.StudentManagementSystem.model.Subject;
import edu.deegrework.StudentManagementSystem.repository.SpecializationRepository;
import edu.deegrework.StudentManagementSystem.repository.SubjectRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.request.converter.SubjectRequestConverter;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;
import edu.deegrework.StudentManagementSystem.response.converter.SubjectResponseConverter;
import edu.deegrework.StudentManagementSystem.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final TeamRepository teamRepository;
    private final SubjectRequestConverter requestConverter;
    private final SubjectResponseConverter responseConverter;
    private final SpecializationRepository specializationRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository,
                              TeamRepository teamRepository,
                              SubjectRequestConverter requestConverter,
                              SubjectResponseConverter responseConverter,
                              SpecializationRepository specializationRepository) {
        this.subjectRepository = subjectRepository;
        this.teamRepository = teamRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public SubjectResponse getById(Long id) {
        return subjectRepository.findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("Subject not found this id ::" + id));
    }

    @Override
    public List<SubjectResponse> getAll() {
        return subjectRepository
                .findAll()
                .stream()
                .map(responseConverter::apply)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectResponse save(SubjectRequest subjectRequest) {
        List<Specialization> specializations = subjectRequest.getSpecializationsId()
                .stream()
                .map(specializationRepository::getById)
                .collect(Collectors.toList());
        Subject subject = requestConverter.apply(subjectRequest);
        subject.setSpecializations(specializations);
        return responseConverter.apply(subjectRepository.save(subject));
    }

    @Override
    public SubjectResponse update(Long id, SubjectRequest subjectRequest) {
        if (existsById(id)) {
            subjectRequest.setId(id);
            return save(subjectRequest);
        } else {
            throw new RecordNotFoundException("Subject not found this id :: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return subjectRepository.existsById(id);
    }
}

package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Faculty;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.repository.FacultyRepository;
import edu.deegrework.StudentManagementSystem.repository.UniversityRepository;
import edu.deegrework.StudentManagementSystem.request.FacultyRequest;
import edu.deegrework.StudentManagementSystem.request.converter.FacultyRequestConverter;
import edu.deegrework.StudentManagementSystem.response.FacultyResponse;
import edu.deegrework.StudentManagementSystem.response.converter.FacultyResponseConverter;
import edu.deegrework.StudentManagementSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final FacultyRequestConverter requestConverter;
    private final FacultyResponseConverter responseConverter;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository, UniversityRepository universityRepository, FacultyRequestConverter requestConverter, FacultyResponseConverter responseConverter) {
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
    }

    @Override
    public FacultyResponse getById(Long id) {
        return facultyRepository.findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("Faculty not found this id ::" + id));
    }

    @Override
    public List<FacultyResponse> getAll() {
        return facultyRepository.findAll()
                .stream()
                .map(responseConverter::apply)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyResponse save(FacultyRequest facultyRequest) {
//        if (facultyRequest.getUniversityId()!=null) {
            University university = universityRepository.findById(facultyRequest.getUniversityId())
                    .orElseThrow(() -> new RecordNotFoundException("University not found this id :: " + facultyRequest.getUniversityId()));
            Faculty faculty = requestConverter.apply(facultyRequest);
            faculty.setUniversity(university);
            Faculty save = facultyRepository.save(faculty);
            return new FacultyResponseConverter().apply(save);
//        }else{
//            throw new RequiredFieldException("universityId must not be null !");
//        }
    }

    @Override
    public FacultyResponse update(Long id, FacultyRequest facultyRequest) {
        if (existsById(id)) {
            facultyRequest.setId(id);
            return this.save(facultyRequest);
        } else {
            throw new RecordNotFoundException("Faculty not found this id :: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return facultyRepository.existsById(id);
    }
}

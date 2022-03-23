package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.request.converter.StudentRequestConverter;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.converter.StudentResponseConverter;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final TeamRepository teamRepository;
    private final StudentResponseConverter responseConverter;
    private final StudentRequestConverter requestConverter;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              TeamRepository teamRepository,
                              StudentResponseConverter responseConverter,
                              StudentRequestConverter requestConverter) {
        this.studentRepository = studentRepository;
        this.teamRepository = teamRepository;
        this.responseConverter = responseConverter;
        this.requestConverter = requestConverter;
    }

    public StudentResponse getById(Long id) {
        return studentRepository.findById(id)
                .map(responseConverter::apply)
                .orElseThrow(() -> new RecordNotFoundException("Student not found this id :: " + id));
    }

    @Override
    public List<StudentResponse> getAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(responseConverter::apply)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Team team = teamRepository.findById(studentRequest.getTeamId())
                .orElseThrow(() -> new RecordNotFoundException("Team not found this id :: " + studentRequest.getTeamId()));
        Student student = requestConverter.apply(studentRequest);
        student.setTeam(team);
        return responseConverter.apply(studentRepository.save(student));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        if (existsById(id)) {
            studentRequest.setId(id);
            return save(studentRequest);
        } else {
            throw new RecordNotFoundException("Student not found this id :: " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Student not found this id :: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
}

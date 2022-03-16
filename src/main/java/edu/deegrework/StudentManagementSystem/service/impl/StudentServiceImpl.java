package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.request.converter.StudentRequestConverter;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.StudentResponseConverter;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TeamRepository teamRepository) {
        this.studentRepository = studentRepository;
        this.teamRepository = teamRepository;
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("Student not found this id :: " + id));
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.findAll();
        // is null elave olunmali
        if (!students.isEmpty()) {
            return students;
        }
        throw new RecordNotFoundException("Students not found");
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Team team = teamRepository.findById(studentRequest.getTeamId())
                .orElseThrow(() -> new RecordNotFoundException("Team not found this id :: " + studentRequest.getTeamId()));
        Student student = new StudentRequestConverter().apply(studentRequest);
        student.setTeam(team);
        Student save = studentRepository.save(student);
        return new StudentResponseConverter().apply(save);
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
    public boolean removeById(Long id) {
        if (existsById(id)) {
            return studentRepository.removeById(id);
        }else{
            throw new RecordNotFoundException("Student not found this id :: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
}

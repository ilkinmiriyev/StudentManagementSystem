package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.email.EmailSender;
import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.repository.CustomUserDetailsRepository;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.StudentRequest;
import edu.deegrework.StudentManagementSystem.request.converter.StudentRequestConverter;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.converter.StudentResponseConverter;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final String UNIVERSITY_EMAİL = "dia.academy.edu@gmail.com";
    private static final String REGISTRATION_SUBJECT = "Registration SMS";

    private final StudentRepository studentRepository;
    private final CustomUserDetailsRepository userDetailsRepository;
    private final TeamRepository teamRepository;
    private final StudentResponseConverter responseConverter;
    private final StudentRequestConverter requestConverter;
    private final PasswordEncoder encoder;
    private final EmailSender emailSender;

    public StudentResponse getStudent(Long id) {
        log.info("ActionLog.getStudent.start studentId: {}", id);
        return studentRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<StudentResponse> getStudents() {
        log.info("ActionLog.getStudents.start");
        return studentRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        log.info("ActionLog.save.start");
        boolean userExist = userDetailsRepository.findByEmail(studentRequest.getEmail()).isPresent();
        if (studentRequest.getId() == null && userExist) {
            log.error("ActionLog.save.error email already taken: {}", studentRequest.getEmail());
            throw new IllegalStateException("email already taken");
        }
        Team team = teamRepository.findById(studentRequest.getTeamId())
                .orElseThrow(() -> new RecordNotFoundException("Team not found with id: " + studentRequest.getTeamId()));
        studentRequest.setPassword(encoder.encode(studentRequest.getPassword()));
        Student student = requestConverter.apply(studentRequest);
        student.setTeam(team);
        student.setDeleted(Boolean.FALSE);
        student.getUserDetails().setEnabled(Boolean.TRUE);
        student.getUserDetails().setLocked(Boolean.FALSE);
        /*emailSender.sendMail(
                        UNIVERSITY_EMAİL,
                        studentRequest.getEmail(),
                        REGISTRATION_SUBJECT,
                        "Siz Tələbə idarəetmə tətbiqində qeydiyyatdan keçmisiniz");*/
        return responseConverter.apply(studentRepository.save(student));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        log.info("ActionLog.update.start studentId: {}", id);
        if (existsById(id)) {
            studentRequest.setId(id);
            return save(studentRequest);
        } else {
            log.error("ActionLog.update.error student not found with id: {}", id);
            throw new RecordNotFoundException("Student not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        log.info("ActionLog.delete.start studentId: {}", id);
        if (existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            log.error("ActionLog.delete.error student not found with id: {}", id);
            throw new RecordNotFoundException("Student not found with id: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
}
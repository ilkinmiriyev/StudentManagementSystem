package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.email.EmailSender;
import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.model.TeacherEntity;
import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import edu.deegrework.StudentManagementSystem.repository.CustomUserDetailsRepository;
import edu.deegrework.StudentManagementSystem.repository.SubjectRepository;
import edu.deegrework.StudentManagementSystem.repository.TeacherRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.TeacherRequest;
import edu.deegrework.StudentManagementSystem.request.converter.TeacherRequestConverter;
import edu.deegrework.StudentManagementSystem.response.TeacherResponse;
import edu.deegrework.StudentManagementSystem.response.converter.TeacherResponseConverter;
import edu.deegrework.StudentManagementSystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private static final String UNIVERSITY_EMAİL = "dia.academy.edu@gmail.com";
    private static final String REGISTRATION_SUBJECT = "Registration SMS";

    private final TeacherRepository teacherRepository;
    private final TeacherResponseConverter responseConverter;
    private final TeacherRequestConverter requestConverter;
    private final TeamRepository teamRepository;
    private final SubjectRepository subjectRepository;
    private final CustomUserDetailsRepository userDetailsRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder encoder;

    @Override
    public TeacherResponse getTeacher(Long id) {
        return teacherRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(()-> new RecordNotFoundException("Teacher not found with id: "+id));
    }

    @Override
    public List<TeacherResponse> getTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponse save(TeacherRequest request) {
        log.info("ActionLog.save.start");
        boolean userExist = userDetailsRepository.findByEmail(request.getEmail()).isPresent();
        if (request.getId()==null && userExist){
            log.error("ActionLog.save.error email already taken: {}", request.getEmail());
            throw new IllegalStateException("email already taken");
        }
        request.setPassword(encoder.encode(request.getPassword()));
        TeacherEntity teacher = requestConverter.apply(request);

        SubjectEntity subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RecordNotFoundException("Subject not found with id: " + request.getSubjectId()));
        List<TeamEntity> teams = request.getTeamsId()
                .stream()
                .map(teamRepository::getById)
                .collect(Collectors.toList());

        teacher.setSubject(subject);
        teacher.setTeams(teams);
        teacher.getUserDetails().setEnabled(Boolean.TRUE);
        teacher.getUserDetails().setLocked(Boolean.FALSE);
        /*emailSender.sendMail(
                UNIVERSITY_EMAİL,
                request.getEmail(),
                REGISTRATION_SUBJECT,
                "Siz Tələbə idarəetmə tətbiqində qeydiyyatdan keçmisiniz");*/
        return responseConverter.apply(teacherRepository.save(teacher));
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest request) {
        if (existsById(id)){
            request.setId(id);
            return save(request);
        }else{
            throw new RecordNotFoundException("Teacher not found with id: "+id);
        }
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            teacherRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Teacher not found with id: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return teacherRepository.existsById(id);
    }
}

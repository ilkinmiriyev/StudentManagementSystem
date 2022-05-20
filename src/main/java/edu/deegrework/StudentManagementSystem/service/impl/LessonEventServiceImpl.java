package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.*;
import edu.deegrework.StudentManagementSystem.repository.*;
import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import edu.deegrework.StudentManagementSystem.request.converter.LessonEventRequestConverter;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
import edu.deegrework.StudentManagementSystem.response.converter.LessonEventResponseConverter;
import edu.deegrework.StudentManagementSystem.service.LessonEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LessonEventServiceImpl implements LessonEventService {

    private final LessonEventRepository lessonEventRepository;
    private final LessonEventResponseConverter responseConverter;
    private final LessonEventRequestConverter requestConverter;
    private final TeamRepository teamRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;


    @Override
    public LessonEventResponse getLessonEvent(Long id) {
        return lessonEventRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("LessonEvent not found with id: " + id));
    }

    @Override
    public List<LessonEventResponse> getLessonEvents() {
        return lessonEventRepository.findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public LessonEventResponse save(LessonEventRequest request) {

        LessonEventEntity event = new LessonEventEntity();
        SubjectEntity subject = subjectRepository.getById(request.getSubjectId());
        TeamEntity team = teamRepository.getById(request.getTeamId());
        event.setLessonDate(request.getLessonDate());
        event.setSubject(subject);
        event.setTeam(team);
        return responseConverter.apply(lessonEventRepository.save(event));
    }

//    @Override
//    public LessonEventResponse save(LessonEventRequest request) {
//        LessonEventEntity lessonEvent = requestConverter.apply(request);
//        TeamEntity team = teamRepository.findById(request.getTeamId())
//                .orElseThrow(() -> new RecordNotFoundException("Team not found with id: " + request.getTeamId()));
//        SubjectEntity subject = subjectRepository.findById(request.getSubjectId())
//                .orElseThrow(() -> new RecordNotFoundException("Subject not found with id: " + request.getSubjectId()));
//        TeacherEntity teacher = teacherRepository.findById(request.getTeacherId())
//                .orElseThrow(() -> new RecordNotFoundException("Teacher not found with id: " + request.getTeacherId()));
//
//        //todo: AttendanceItems frontda yaranmalidir
//        request.getItemRequests()
//                .stream()
//                .filter(i -> !i.getStatus())
//                .map(i -> studentRepository.getById(i.getStudentId()))
//                .forEach(s -> s.setLessonLimit(s.getLessonLimit() - 1));
//
//        lessonEvent.setTeam(team);
//        lessonEvent.setSubject(subject);
//        lessonEvent.setTeacher(teacher);
//        return responseConverter
//                .apply(lessonEventRepository.save(lessonEvent));
//    }

    @Override
    public LessonEventResponse update(Long id, LessonEventRequest request) {
        if (existsById(id)) {
            request.setId(id);
            return save(request);
        } else {
            throw new RecordNotFoundException("LessonEvent not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            lessonEventRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("LessonEvent not found with id: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return lessonEventRepository.existsById(id);
    }
}

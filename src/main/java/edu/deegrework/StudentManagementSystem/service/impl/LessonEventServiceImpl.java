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

//    public LessonEvent createLessonEvent(LessonEventRequest request) {
//
//        // todo: save methodunu duzeltmek Parametr listi
//        LessonEvent event = new LessonEvent();
//        lessonEventRepository.save(event);
//        Subject subject = subjectRepository.getById(request.getSubjectId());
//        Team team = teamRepository.getById(request.getTeamId());
//        Teacher teacher = teacherRepository.getById(request.getTeacherId());
//        List<AttendanceItem> items = team.getStudents()
//                .stream()
//                .map(student -> new AttendanceItem(
//                        null,
//                        student,
//                        event,
//                        true))
//                .collect(Collectors.toList());
//
//        event.setAttendanceItems(items);
//        event.setTeacher(teacher);
//        event.setSubject(subject);
//        event.setTeam(team);
//        return lessonEventRepository.save(event);
//    }

    @Override
    public LessonEventResponse save(LessonEventRequest request) {
        LessonEvent lessonEvent = requestConverter.apply(request);
        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RecordNotFoundException("Team not found with id: " + request.getTeamId()));
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RecordNotFoundException("Subject not found with id: " + request.getSubjectId()));
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RecordNotFoundException("Teacher not found with id: " + request.getTeacherId()));

        //todo: AttendanceItems frontda yaranmalidir
        request.getItemRequests()
                .stream()
                .filter(i -> !i.getStatus())
                .map(i -> studentRepository.getById(i.getStudentId()))
                .forEach(s -> s.setLessonLimit(s.getLessonLimit() - 1));

        lessonEvent.setTeam(team);
        lessonEvent.setSubject(subject);
        lessonEvent.setTeacher(teacher);
        return responseConverter
                .apply(lessonEventRepository.save(lessonEvent));
    }

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

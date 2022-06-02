package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.LessonEventEntity;
import edu.deegrework.StudentManagementSystem.model.ScoreEntity;
import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import edu.deegrework.StudentManagementSystem.repository.*;
import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import edu.deegrework.StudentManagementSystem.request.converter.LessonEventRequestConverter;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
import edu.deegrework.StudentManagementSystem.response.converter.LessonEventResponseConverter;
import edu.deegrework.StudentManagementSystem.service.LessonEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LessonEventServiceImpl implements LessonEventService {

    private final LessonEventRepository lessonRepository;
    private final LessonEventResponseConverter responseConverter;
    private final LessonEventRequestConverter requestConverter;
    private final TeamRepository teamRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;


    @Override
    public LessonEventResponse getLessonEvent(Long id) {
        return lessonRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("LessonEvent not found with id: " + id));
    }

    @Override
    public List<LessonEventResponse> getLessonEvents() {
        return lessonRepository.findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public List<LessonEventResponse> getEventByTeamIdAndSubjectId(Long teamId, Long subjectId) {
        return null;
    }

//    @Override
//    public List<LessonEventResponse> getEventByTeamIdAndSubjectId(Long teamId, Long subjectId) {
//        TeamEntity team = teamRepository.getById(teamId);
//        SubjectEntity subject = subjectRepository.getById(subjectId);
//        return lessonRepository.getLessonEventEntitiesByTeamAndSubject(team, subject)
//                .get()
//                .stream()
//                .map(x -> {
//                    LessonEventResponse eventResponse = responseConverter.apply(x);
//                    List<AttendanceItemResponse> itemResponses = x.getItemEntities().stream()
//                            .map(itemResponseConverter)
//                            .collect(Collectors.toList());
//                    eventResponse.setAttendanceItems(itemResponses);
//                    return eventResponse;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public LessonEventResponse save(LessonEventRequest request) {
        LessonEventEntity lessonEvent = requestConverter.apply(request);
        SubjectEntity subject = subjectRepository.getById(request.getSubjectId());
        TeamEntity team = teamRepository.getById(request.getTeamId());
        lessonEvent.setSubject(subject);
        lessonEvent.setTeam(team);
        LessonEventEntity lesson = lessonRepository.save(lessonEvent);

        List<ScoreEntity> scores = new ArrayList<>();
        studentRepository.findAllByTeamId(request.getTeamId())
                .forEach(s -> {
                    scores.add(new ScoreEntity(null, s, lesson, null));
                });
        scoreRepository.saveAll(scores);
        return responseConverter
                .apply(lesson);
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
            lessonRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("LessonEvent not found with id: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return lessonRepository.existsById(id);
    }
}

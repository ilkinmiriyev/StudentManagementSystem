package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;

import java.util.List;

public interface LessonEventService{

    LessonEventResponse getLessonEvent(Long id);

    List<LessonEventResponse> getLessonEvents();

    List<LessonEventResponse> getEventByTeamIdAndSubjectId(Long teamId, Long subjectId);

    LessonEventResponse save(LessonEventRequest request);

    LessonEventResponse update(Long id, LessonEventRequest event);

    void delete(Long id);

    boolean existsById(Long id);
}

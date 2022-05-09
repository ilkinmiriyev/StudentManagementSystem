package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.LessonEvent;
import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LessonEventRequestConverter implements Function<LessonEventRequest, LessonEvent> {

    @Override
    public LessonEvent apply(LessonEventRequest request) {
        return LessonEvent.builder()
                .id(request.getId())
                .date(request.getDate())
                .build();
    }
}

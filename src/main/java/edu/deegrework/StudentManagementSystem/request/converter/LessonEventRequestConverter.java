package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.LessonEventEntity;
import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LessonEventRequestConverter implements Function<LessonEventRequest, LessonEventEntity> {

    @Override
    public LessonEventEntity apply(LessonEventRequest request) {
        return LessonEventEntity.builder()
                .id(request.getId())
                .lessonDate(request.getLessonDate())
                .build();
    }
}

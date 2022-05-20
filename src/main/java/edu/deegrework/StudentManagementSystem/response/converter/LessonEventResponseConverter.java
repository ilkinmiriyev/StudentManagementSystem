package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.LessonEventEntity;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LessonEventResponseConverter
        implements Function<LessonEventEntity, LessonEventResponse> {
    @Override
    public LessonEventResponse apply(LessonEventEntity lessonEvent) {
        return LessonEventResponse.builder()
                .id(lessonEvent.getId())
                .lessonDate(lessonEvent.getLessonDate())
                .build();
    }
}

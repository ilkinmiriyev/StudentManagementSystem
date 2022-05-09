package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.LessonEvent;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LessonEventResponseConverter
        implements Function<LessonEvent, LessonEventResponse> {
    @Override
    public LessonEventResponse apply(LessonEvent lessonEvent) {
        return LessonEventResponse.builder()
                .id(lessonEvent.getId())
                .date(lessonEvent.getDate())
                .build();
    }
}

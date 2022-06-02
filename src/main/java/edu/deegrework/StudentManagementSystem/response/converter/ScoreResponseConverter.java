package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.ScoreEntity;
import edu.deegrework.StudentManagementSystem.response.ScoreResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ScoreResponseConverter implements Function<ScoreEntity, ScoreResponse> {

    @Override
    public ScoreResponse apply(ScoreEntity score) {
        return ScoreResponse.builder()
                .id(score.getId())
                .grade(score.getGrade())
                .lessonDate(score.getLesson().getLessonDate())
                .build();
    }
}

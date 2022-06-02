package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.ScoreEntity;
import edu.deegrework.StudentManagementSystem.request.ScoreRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ScoreRequestConverter implements Function<ScoreRequest, ScoreEntity> {
    @Override
    public ScoreEntity apply(ScoreRequest request) {
        return ScoreEntity.builder()
                .id(request.getId())
                .grade(request.getGrade())
                .build();
    }
}

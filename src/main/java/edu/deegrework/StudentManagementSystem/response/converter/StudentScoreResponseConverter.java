package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.response.StudentScoreResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentScoreResponseConverter implements Function<StudentEntity, StudentScoreResponse> {
    @Override
    public StudentScoreResponse apply(StudentEntity student) {
        return StudentScoreResponse.builder()
                .studentId(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();
    }
}

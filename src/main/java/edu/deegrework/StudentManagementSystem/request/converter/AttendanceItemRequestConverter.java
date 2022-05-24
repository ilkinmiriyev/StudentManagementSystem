package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.AttendanceItemEntity;
import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AttendanceItemRequestConverter implements Function<AttendanceItemRequest, AttendanceItemEntity> {

    @Override
    public AttendanceItemEntity apply(AttendanceItemRequest request) {
        return AttendanceItemEntity.builder()
                .id(request.getId())
                .grade(request.getGrade())
                .build();
    }
}

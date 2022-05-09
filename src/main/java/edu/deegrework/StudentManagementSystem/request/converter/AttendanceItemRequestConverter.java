package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.AttendanceItem;
import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AttendanceItemRequestConverter implements Function<AttendanceItemRequest, AttendanceItem> {

    @Override
    public AttendanceItem apply(AttendanceItemRequest request) {
        return AttendanceItem.builder()
                .id(request.getId())
                .status(request.getStatus())
                .build();
    }
}

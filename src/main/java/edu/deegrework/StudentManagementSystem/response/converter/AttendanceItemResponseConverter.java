package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.AttendanceItemEntity;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AttendanceItemResponseConverter implements Function<AttendanceItemEntity, AttendanceItemResponse> {

    @Override
    public AttendanceItemResponse apply(AttendanceItemEntity attendanceItem) {
        return AttendanceItemResponse.builder()
                .id(attendanceItem.getId())
                .grade(attendanceItem.getGrade())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.AttendanceItem;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AttendanceItemResponseConverter implements Function<AttendanceItem, AttendanceItemResponse> {

    @Override
    public AttendanceItemResponse apply(AttendanceItem attendanceItem) {
        return AttendanceItemResponse.builder()
                .id(attendanceItem.getId())
                .status(attendanceItem.getStatus())
                .build();
    }
}

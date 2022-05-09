package edu.deegrework.StudentManagementSystem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
public class LessonEventResponse {
    private Long id;
    private Date date;
    private List<AttendanceItemResponse> attendanceItems;
}

package edu.deegrework.StudentManagementSystem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class LessonEventResponse {
    private Long id;
//    private Long teamId;
//    private Long subjectId;
    private Date lessonDate;
//    private List<AttendanceItemResponse> attendanceItems;
}

package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LessonEventRequest {
    private Long id;
    private Long teamId;
    private Long subjectId;
//    private Long teacherId;
    private Date lessonDate;
//    private List<AttendanceItemRequest> itemRequests;
}

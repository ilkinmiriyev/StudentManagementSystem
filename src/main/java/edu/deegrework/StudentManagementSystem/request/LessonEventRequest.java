package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class LessonEventRequest {
    private Long id;
    private Long subjectId;
    private Long teamId;
    private Long teacherId;
    private Date date;
    private List<AttendanceItemRequest> itemRequests;
}

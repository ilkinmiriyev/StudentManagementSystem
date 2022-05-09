package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttendanceItemRequest {
    private Long id;
    private Long studentId;
    private Long lessonEvent;
    private Boolean status;
}

package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
public class AttendanceItemRequest {
    private Long id;
    private Long studentId;
    private Long lessonEventId;
    @Min(-2)
    @Max(100)
    private Integer grade;
}

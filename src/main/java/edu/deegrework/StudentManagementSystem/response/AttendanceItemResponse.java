package edu.deegrework.StudentManagementSystem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AttendanceItemResponse {
    private Long id;
    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer grade;
}

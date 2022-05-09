package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectRequest {
    private Long id;
    private String name;
    private List<Long> specializationsId;

    private Integer creditNumber;
}

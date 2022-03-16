package edu.deegrework.StudentManagementSystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopicRequest {
    private Long id;
    private String name;
    private Long subjectId;
}

package edu.deegrework.StudentManagementSystem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class TeamResponse {
    private Long id;
    private String name;
}

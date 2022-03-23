package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;

import java.util.List;

public interface TeamService {

    TeamResponse getById(Long id);

    List<TeamResponse> getAll();

    TeamResponse save(TeamRequest teamRequest);

    TeamResponse update(Long id, TeamRequest teamRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

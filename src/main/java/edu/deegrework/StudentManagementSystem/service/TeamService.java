package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;

import java.util.List;

public interface TeamService {

    TeamResponse getTeam(Long id);

    List<TeamResponse> getTeams();

    TeamResponse save(TeamRequest teamRequest);

    TeamResponse update(Long id, TeamRequest teamRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

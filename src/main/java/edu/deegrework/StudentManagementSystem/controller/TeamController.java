package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;
import edu.deegrework.StudentManagementSystem.response.TeamSubjectResponse;
import edu.deegrework.StudentManagementSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1/teams", produces = "application/json")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamResponse getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @GetMapping("/teacher-email")
    @ResponseStatus(HttpStatus.OK)
    public TeamSubjectResponse getTeamsByTeacherEmail(@RequestParam(name = "email") String email){
        return teamService.getTeamsByTeacherEmail(email);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponse save(@RequestBody TeamRequest teamRequest) {
        return teamService.save(teamRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamResponse update(@PathVariable Long id,
                               @RequestBody TeamRequest teamRequest) {
        return teamService.update(id, teamRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}

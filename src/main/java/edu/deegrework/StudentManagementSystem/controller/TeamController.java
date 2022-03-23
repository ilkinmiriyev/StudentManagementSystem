package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;
import edu.deegrework.StudentManagementSystem.response.converter.TeamResponseConverter;
import edu.deegrework.StudentManagementSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/team", produces = "application/json")
public class TeamController {

    private final TeamService teamService;
    private final TeamResponseConverter converter;

    @Autowired
    public TeamController(TeamService teamService, TeamResponseConverter converter) {
        this.teamService = teamService;
        this.converter = converter;
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable Long teamId) {
        TeamResponse teamResponse = teamService.getById(teamId);
        return new ResponseEntity<>(teamResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAll() {
        List<TeamResponse> teamResponses = teamService.getAll();
        return new ResponseEntity<>(teamResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamResponse> save(@RequestBody TeamRequest teamRequest) {
        TeamResponse teamResponse = teamService.save(teamRequest);
        return new ResponseEntity<>(teamResponse, HttpStatus.OK);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<TeamResponse> update(@PathVariable Long teamId,
                                                     @RequestBody TeamRequest teamRequest) {
        TeamResponse teamResponse = teamService.update(teamId, teamRequest);
        return new ResponseEntity<>(teamResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<TeamResponse> deleteById(@PathVariable Long teamId) {
        teamService.deleteById(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

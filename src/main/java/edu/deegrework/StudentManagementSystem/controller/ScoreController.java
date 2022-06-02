package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.ScoreRequest;
import edu.deegrework.StudentManagementSystem.response.ScoreResponse;
import edu.deegrework.StudentManagementSystem.response.StudentScoreResponse;
import edu.deegrework.StudentManagementSystem.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/v1/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/{teamId}/{subjectId}")
    public List<StudentScoreResponse> getScoresByTeamIdAndSubjectId(@PathVariable Long teamId,
                                                                    @PathVariable Long subjectId) {
        return scoreService.getScoresByTeamIdAndSubjectId(teamId, subjectId);
    }

    @PostMapping
    public ScoreResponse save(@RequestBody ScoreRequest request) {
        return scoreService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scoreService.delete(id);
    }
}

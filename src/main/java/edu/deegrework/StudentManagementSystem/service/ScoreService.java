package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.ScoreRequest;
import edu.deegrework.StudentManagementSystem.response.ScoreResponse;
import edu.deegrework.StudentManagementSystem.response.StudentScoreResponse;

import java.util.List;

public interface ScoreService {

    ScoreResponse getScore(Long id);

    List<ScoreResponse> getScores();

    List<StudentScoreResponse> getScoresByTeamIdAndSubjectId(Long teamId, Long subjectId);

    List<ScoreResponse> getScoresByStudentIdAndSubjectId(Long studentId, Long subjectId);

    List<ScoreResponse> saveAll(List<ScoreRequest> request);

    ScoreResponse save(ScoreRequest request);

    ScoreResponse update(Long id, ScoreRequest request);

    void delete(Long id);

    boolean existsById(Long id);
}

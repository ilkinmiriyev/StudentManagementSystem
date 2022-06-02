package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.ScoreEntity;
import edu.deegrework.StudentManagementSystem.repository.ScoreRepository;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.request.ScoreRequest;
import edu.deegrework.StudentManagementSystem.request.converter.ScoreRequestConverter;
import edu.deegrework.StudentManagementSystem.response.ScoreResponse;
import edu.deegrework.StudentManagementSystem.response.StudentScoreResponse;
import edu.deegrework.StudentManagementSystem.response.converter.ScoreResponseConverter;
import edu.deegrework.StudentManagementSystem.response.converter.StudentScoreResponseConverter;
import edu.deegrework.StudentManagementSystem.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final ScoreResponseConverter responseConverter;
    private final ScoreRequestConverter requestConverter;
    private final StudentRepository studentRepository;
    private final ScoreResponseConverter scoreResponseConverter;
    private final StudentScoreResponseConverter studentScoreResponseConverter;


    @Override
    public ScoreResponse getScore(Long id) {
        return scoreRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<ScoreResponse> getScores() {
        return scoreRepository.findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreResponse> saveAll(List<ScoreRequest> request) {
        List<ScoreEntity> scores = request.stream()
                .map(requestConverter)
                .collect(Collectors.toList());
        return scoreRepository.saveAll(scores)
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public ScoreResponse save(ScoreRequest request) {
        ScoreEntity score = scoreRepository.getById(request.getId());
        score.setGrade(request.getGrade());
        return scoreResponseConverter.apply(scoreRepository.save(score));
    }

    @Override
    public List<StudentScoreResponse> getScoresByTeamIdAndSubjectId(Long teamId, Long subjectId) {
        return studentRepository.findAllByTeamId(teamId)
                .stream()
                .map(s-> {
                    StudentScoreResponse response = studentScoreResponseConverter.apply(s);
                    response.setScores(
                    scoreRepository
                            .getAllByStudentIdAndLesson_SubjectId(response.getStudentId(), subjectId)
                            .stream()
                            .map(scoreResponseConverter)
                            .collect(Collectors.toList())
                    );
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ScoreResponse> getScoresByStudentIdAndSubjectId(Long studentId, Long subjectId) {
        return scoreRepository
                .getAllByStudentIdAndLesson_SubjectId(studentId, subjectId)
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public ScoreResponse update(Long id, ScoreRequest request) {
        if (existsById(id)) {
            request.setId(id);
            return save(request);
        } else {
            throw new RecordNotFoundException("Score not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        scoreRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return scoreRepository.existsById(id);
    }
}

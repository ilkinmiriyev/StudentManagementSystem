package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.SpecializationEntity;
import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.model.TeacherEntity;
import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import edu.deegrework.StudentManagementSystem.repository.UserRepository;
import edu.deegrework.StudentManagementSystem.repository.SpecializationRepository;
import edu.deegrework.StudentManagementSystem.repository.TeacherRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.request.TeamRequest;
import edu.deegrework.StudentManagementSystem.request.converter.TeamRequestConverter;
import edu.deegrework.StudentManagementSystem.response.TeamResponse;
import edu.deegrework.StudentManagementSystem.response.TeamSubjectResponse;
import edu.deegrework.StudentManagementSystem.response.converter.TeamResponseConverter;
import edu.deegrework.StudentManagementSystem.model.User;
import edu.deegrework.StudentManagementSystem.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userDetailsRepository;
    private final SpecializationRepository specializationRepository;
    private final TeamResponseConverter responseConverter;
    private final TeamRequestConverter requestConverter;

    @Override
    public TeamResponse getTeam(Long id) {
        return teamRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("Team not found with id:" + id));
    }

    public TeamSubjectResponse getTeamsByTeacherEmail(String teacherEmail) {
        Optional<User> userDetails = userDetailsRepository.findByEmail(teacherEmail);
        Optional<TeacherEntity> teacher = teacherRepository.findByUserDetails(userDetails.get());
        SubjectEntity subject = teacher.get().getSubject();
        List<TeamEntity> teams = teamRepository.findAllByTeachers(teacher.get());
        List<TeamResponse> collect = teams
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());

        TeamSubjectResponse response = new TeamSubjectResponse();
        response.setTeams(collect);
        response.setSubjectId(subject.getId());
        response.setSubjectName(subject.getName());
        return response;
    }

    @Override
    public List<TeamResponse> getTeams() {
        return teamRepository
                .findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public TeamResponse save(TeamRequest teamRequest) {
        SpecializationEntity specialization = specializationRepository
                .findById(teamRequest.getSpecializationId())
                .orElseThrow(() -> new RecordNotFoundException("Specialization not found with id: " + teamRequest.getSpecializationId()));
        TeamEntity team = requestConverter.apply(teamRequest);
        team.setSpecialization(specialization);
        return responseConverter.apply(teamRepository.save(team));
    }

    @Override
    public TeamResponse update(Long id, TeamRequest teamRequest) {
        if (existsById(id)) {
            teamRequest.setId(id);
            return save(teamRequest);
        } else {
            throw new RecordNotFoundException("Team not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return teamRepository.existsById(id);
    }
}

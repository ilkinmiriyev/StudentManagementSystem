package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.LessonEventEntity;
import edu.deegrework.StudentManagementSystem.model.SubjectEntity;
import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonEventRepository extends JpaRepository<LessonEventEntity, Long> {
    Optional<List<LessonEventEntity>> getLessonEventEntitiesByTeamAndSubject(TeamEntity team, SubjectEntity subject);
}

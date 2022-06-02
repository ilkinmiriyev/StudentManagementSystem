package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByUserDetails(UserDetails userDetails);

    List<StudentEntity> findAllByTeamId(Long id);

//    @Query(
////            value = "SELECT new edu.deegrework.StudentManagementSystem.response.StudentScoreResponse(l.lessonDate AS lessonDate, l.team.id AS teamId, l.subject.id AS subjectId, s.id AS scorId, s.student.id AS studentId, s.grade AS grade) FROM LessonEventEntity l, ScoreEntity s WHERE l.id=s.lesson.id AND l.team.id =?1 AND l.subject.id =?2"
//            value = "SELECT s FROM StudentEntity s WHERE s.team.id = :teamId "
//    )
//    List<StudentScoreResponse> findAllByTeamIdAndSubjectId(Long teamId);
}

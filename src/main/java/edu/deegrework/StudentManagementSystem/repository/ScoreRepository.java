package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
//    Optional<List<AttendanceItemEntity>> getAttendanceItemEntitiesByLessonEvent_Id(Long id);
//    Optional<List<AttendanceItemEntity>> getAttendanceItemEntitiesByStudent_Id(Long id);
    List<ScoreEntity> getAllByStudentIdAndLesson_SubjectId(Long studentId, Long subjectId);
}

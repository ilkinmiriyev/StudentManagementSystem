package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.AttendanceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceItemRepository extends JpaRepository<AttendanceItemEntity, Long> {
    Optional<List<AttendanceItemEntity>> getAttendanceItemEntitiesByLessonEvent_Id(Long id);
}

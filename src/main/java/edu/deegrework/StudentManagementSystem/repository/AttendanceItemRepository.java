package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.AttendanceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceItemRepository extends JpaRepository<AttendanceItem, Long> {
}

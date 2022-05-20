package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.TeacherEntity;
import edu.deegrework.StudentManagementSystem.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    List<TeamEntity> findAllByTeachers(TeacherEntity teacher);
}

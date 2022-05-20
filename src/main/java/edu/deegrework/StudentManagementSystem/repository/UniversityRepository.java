package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
}

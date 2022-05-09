package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}

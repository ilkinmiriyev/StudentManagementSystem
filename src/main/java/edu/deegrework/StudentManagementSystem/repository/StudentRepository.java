package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByUserDetails(UserDetails userDetails);
}

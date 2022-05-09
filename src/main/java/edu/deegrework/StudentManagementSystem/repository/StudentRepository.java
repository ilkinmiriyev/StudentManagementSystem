package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUserDetails(UserDetails userDetails);
}

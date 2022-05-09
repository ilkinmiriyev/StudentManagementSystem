package edu.deegrework.StudentManagementSystem.repository;

import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserDetailsRepository extends JpaRepository<CustomUserDetails, Long> {
    Optional<CustomUserDetails> findByEmail(String email);
}

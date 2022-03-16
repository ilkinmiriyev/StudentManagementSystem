package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.model.University;

import java.util.List;

public interface UniversityService {

    University getById(Long id);

    List<University> getAll();

    University save(University university);

    void deleteById(Long id);

    boolean existsById(Long id);

}

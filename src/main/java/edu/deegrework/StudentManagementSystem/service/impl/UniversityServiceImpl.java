package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.University;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.UniversityRepository;
import edu.deegrework.StudentManagementSystem.service.StudentService;
import edu.deegrework.StudentManagementSystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University getById(Long id) {
        return universityRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("University not found this id :: " + id));
    }

    @Override
    public List<University> getAll() {
        List<University> universities = universityRepository.findAll();
        // is null elave olunmali
        if (!universities.isEmpty()) {
            return universities;
        }
        throw new RecordNotFoundException("Universities not found");
    }

    @Override
    public University save(University university) {
        return universityRepository.save(university);
    }

    @Override
    public void deleteById(Long id) {
        universityRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return universityRepository.existsById(id);
    }
}

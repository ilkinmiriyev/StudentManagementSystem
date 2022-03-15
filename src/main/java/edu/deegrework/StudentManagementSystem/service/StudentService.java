package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.model.Student;

import java.util.List;

public interface StudentService {

    public Student getById(Long id);

    public List<Student> getAll();

    public Student save(Student student);

    public void deleteById(Long id);

    public boolean existsById(Long id);

}

package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;

import java.util.List;

public interface SubjectService {

    SubjectResponse getById(Long id);

    List<SubjectResponse> getAll();

    SubjectResponse save(SubjectRequest subjectRequest);

    SubjectResponse update(Long id, SubjectRequest subjectRequest);

    void deleteById(Long id);

    boolean existsById(Long id);

}

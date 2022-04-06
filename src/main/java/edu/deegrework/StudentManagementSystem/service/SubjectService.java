package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.SubjectRequest;
import edu.deegrework.StudentManagementSystem.response.SubjectResponse;

import java.util.List;

public interface SubjectService {

    SubjectResponse getSubject(Long id);

    List<SubjectResponse> getSubjects();

    SubjectResponse save(SubjectRequest subjectRequest);

    SubjectResponse update(Long id, SubjectRequest subjectRequest);

    void delete(Long id);

    boolean existsById(Long id);

}

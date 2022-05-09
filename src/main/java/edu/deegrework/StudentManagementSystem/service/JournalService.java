package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.JournalRequest;
import edu.deegrework.StudentManagementSystem.response.JournalResponse;

import java.util.List;

public interface JournalService {

    JournalResponse getJournal(Long id);

    List<JournalResponse> getJournals();

    JournalResponse save(JournalRequest request);

    JournalResponse update(Long id, JournalRequest request);

    void delete(Long id);

    boolean existsById(Long id);
}

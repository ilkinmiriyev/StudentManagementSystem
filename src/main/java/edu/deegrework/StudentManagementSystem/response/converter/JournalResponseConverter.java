package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.Journal;
import edu.deegrework.StudentManagementSystem.response.JournalResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JournalResponseConverter implements Function<Journal, JournalResponse> {
    @Override
    public JournalResponse apply(Journal journal) {
        return JournalResponse.builder()
                .id(journal.getId())
                .build();
    }
}

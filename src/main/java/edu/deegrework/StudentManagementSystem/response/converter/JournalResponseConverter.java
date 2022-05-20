package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.model.JournalEntity;
import edu.deegrework.StudentManagementSystem.response.JournalResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JournalResponseConverter implements Function<JournalEntity, JournalResponse> {
    @Override
    public JournalResponse apply(JournalEntity journal) {
        return JournalResponse.builder()
                .id(journal.getId())
                .build();
    }
}

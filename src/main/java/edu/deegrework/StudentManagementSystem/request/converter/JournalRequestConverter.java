package edu.deegrework.StudentManagementSystem.request.converter;

import edu.deegrework.StudentManagementSystem.model.Journal;
import edu.deegrework.StudentManagementSystem.request.JournalRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JournalRequestConverter implements Function<JournalRequest, Journal> {
    @Override
    public Journal apply(JournalRequest request) {
        return Journal.builder()
                .id(request.getId())
                .build();
    }
}

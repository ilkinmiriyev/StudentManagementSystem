//package edu.deegrework.StudentManagementSystem.request.converter;
//
//import edu.deegrework.StudentManagementSystem.model.JournalEntity;
//import edu.deegrework.StudentManagementSystem.request.JournalRequest;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Function;
//
//@Component
//public class JournalRequestConverter implements Function<JournalRequest, JournalEntity> {
//    @Override
//    public JournalEntity apply(JournalRequest request) {
//        return JournalEntity.builder()
//                .id(request.getId())
//                .build();
//    }
//}

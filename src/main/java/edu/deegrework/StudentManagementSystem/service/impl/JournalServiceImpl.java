//package edu.deegrework.StudentManagementSystem.service.impl;
//
//import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
//import edu.deegrework.StudentManagementSystem.model.JournalEntity;
//import edu.deegrework.StudentManagementSystem.model.TeamEntity;
//import edu.deegrework.StudentManagementSystem.repository.JournalRepository;
//import edu.deegrework.StudentManagementSystem.repository.LessonEventRepository;
//import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
//import edu.deegrework.StudentManagementSystem.request.JournalRequest;
//import edu.deegrework.StudentManagementSystem.request.converter.JournalRequestConverter;
//import edu.deegrework.StudentManagementSystem.response.JournalResponse;
//import edu.deegrework.StudentManagementSystem.response.converter.JournalResponseConverter;
//import edu.deegrework.StudentManagementSystem.service.JournalService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class JournalServiceImpl implements JournalService {
//
//    private final JournalRepository journalRepository;
//    private final JournalResponseConverter responseConverter;
//    private final JournalRequestConverter requestConverter;
//    private final TeamRepository teamRepository;
//    private final LessonEventRepository lessonEventRepository;
//
//    @Override
//    public JournalResponse getJournal(Long id) {
//        return journalRepository.findById(id)
//                .map(responseConverter)
//                .orElseThrow(() -> new RecordNotFoundException("Journal not found with id: " + id));
//    }
//
//    @Override
//    public List<JournalResponse> getJournals() {
//        return journalRepository.findAll()
//                .stream()
//                .map(responseConverter)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public JournalResponse save(JournalRequest request) {
//        JournalEntity journal = requestConverter.apply(request);
//        TeamEntity team = teamRepository.findById(request.getTeamId())
//                .orElseThrow(() -> new RecordNotFoundException("Team not found with id: " + request.getTeamId()));
////        List<LessonEvent> lessonEvents = request.getLessonEventsId()
////                .stream()
////                .map(lessonEventRepository::getById)
////                .collect(Collectors.toList());
//        journal.setTeam(team);
////        journal.setLessonEvents(lessonEvents);
//        return responseConverter.apply(journalRepository.save(journal));
//    }
//
//    @Override
//    public JournalResponse update(Long id, JournalRequest request) {
//        if (existsById(request.getId())) {
//            request.setId(id);
//            return this.save(request);
//        } else {
//            throw new RecordNotFoundException("Journal not found with id: " + id);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        if (existsById(id)) {
//            journalRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException("Journal not found with id: " + id);
//        }
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return journalRepository.existsById(id);
//    }
//}

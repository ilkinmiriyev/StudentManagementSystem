//package edu.deegrework.StudentManagementSystem.service.impl;
//
//import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
//import edu.deegrework.StudentManagementSystem.model.*;
//import edu.deegrework.StudentManagementSystem.repository.*;
//import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
//import edu.deegrework.StudentManagementSystem.request.converter.AttendanceItemRequestConverter;
//import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
//import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
//import edu.deegrework.StudentManagementSystem.response.converter.AttendanceItemResponseConverter;
//import edu.deegrework.StudentManagementSystem.response.converter.LessonEventResponseConverter;
//import edu.deegrework.StudentManagementSystem.service.AttendanceItemService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class AttendanceItemServiceImpl implements AttendanceItemService {
//
//    private final AttendanceItemRepository attendanceItemRepository;
//    private final AttendanceItemRequestConverter requestConverter;
//    private final AttendanceItemResponseConverter responseConverter;
//    private final LessonEventResponseConverter eventResponseConverter;
//    private final TeamRepository teamRepository;
//    private final SubjectRepository subjectRepository;
//    private final StudentRepository studentRepository;
//    private final LessonEventRepository lessonEventRepository;
//
//    @Override
//    public AttendanceItemResponse getAttendanceItem(Long id) {
//        return attendanceItemRepository.findById(id)
//                .map(responseConverter)
//                .orElseThrow(() -> new RecordNotFoundException("AttendanceItem not found with id: " + id));
//    }
//
//    @Override
//    public List<AttendanceItemResponse> getAttendanceItems() {
//        return attendanceItemRepository.findAll()
//                .stream()
//                .map(responseConverter)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AttendanceItemResponse> getAttendanceItemsByTeamIdAndSubjectId(Long teamId, Long subjectId) {
//
//        TeamEntity team = teamRepository.getById(teamId);
//        SubjectEntity subject = subjectRepository.getById(subjectId);
//        List<LessonEventEntity> entities = lessonEventRepository
//                .getLessonEventEntitiesByTeamAndSubject(team, subject).get();
//        entities.stream()
//                .map(x -> {
//                    LessonEventResponse lessonEventResponse = eventResponseConverter.apply(x);
//
//                    List<AttendanceItemResponse> attendanceItemResponses = x.getItemEntities()
//                            .stream()
//                            .map(responseConverter)
//                            .collect(Collectors.toList());
//                    lessonEventResponse.setAttendanceItems(attendanceItemResponses);
//                    return lessonEventResponse;
//                })
//                .collect(Collectors.toList());
//
//
//        return attendanceItemRepository
//                .getAttendanceItemEntitiesByStudent_Id(lessonId)
//                .get()
//                .stream()
//                .map(responseConverter)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AttendanceItemResponse> saveAll(List<AttendanceItemRequest> request) {
//        List<AttendanceItemEntity> collect = request
//                .stream()
//                .map(attendanceItemRequest -> {
//                    Optional<LessonEventEntity> lessonEvent = lessonEventRepository
//                            .findById(attendanceItemRequest.getLessonEventId());
//                    Optional<StudentEntity> student = studentRepository
//                            .findById(attendanceItemRequest.getStudentId());
//                    AttendanceItemEntity attendanceItem = requestConverter.apply(attendanceItemRequest);
//                    attendanceItem.setLessonEvent(lessonEvent.get());
//                    attendanceItem.setStudent(student.get());
//                    return attendanceItem;
//                })
//                .collect(Collectors.toList());
//        return attendanceItemRepository.saveAll(collect)
//                .stream()
//                .map(responseConverter)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public AttendanceItemResponse save(AttendanceItemRequest request) {
//        AttendanceItemEntity item = requestConverter.apply(request);
//        StudentEntity student = studentRepository.findById(request.getStudentId())
//                .orElseThrow(() -> new RecordNotFoundException("Student not found with id: " + request.getStudentId()));
//        LessonEventEntity lessonEvent = lessonEventRepository.findById(request.getLessonEventId())
//                .orElseThrow(() -> new RecordNotFoundException("LessonEvent not found with id: " + request.getLessonEventId()));
//        item.setLessonEvent(lessonEvent);
//        item.setStudent(student);
//        return responseConverter.apply(attendanceItemRepository.save(item));
//    }
//
//    @Override
//    public AttendanceItemResponse update(Long id, AttendanceItemRequest request) {
//        if (existsById(id)) {
//            request.setId(id);
//            return save(request);
//        } else {
//            throw new RecordNotFoundException("AttendanceItem not found with id: " + id);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        if (existsById(id)) {
//            attendanceItemRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException("AttendanceItem not found with id: " + id);
//        }
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return attendanceItemRepository.existsById(id);
//    }
//}

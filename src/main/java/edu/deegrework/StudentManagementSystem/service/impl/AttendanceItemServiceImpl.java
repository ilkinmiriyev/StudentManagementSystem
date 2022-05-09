package edu.deegrework.StudentManagementSystem.service.impl;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.AttendanceItem;
import edu.deegrework.StudentManagementSystem.model.LessonEvent;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.repository.AttendanceItemRepository;
import edu.deegrework.StudentManagementSystem.repository.LessonEventRepository;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import edu.deegrework.StudentManagementSystem.request.converter.AttendanceItemRequestConverter;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
import edu.deegrework.StudentManagementSystem.response.converter.AttendanceItemResponseConverter;
import edu.deegrework.StudentManagementSystem.service.AttendanceItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceItemServiceImpl implements AttendanceItemService {

    private final AttendanceItemRepository attendanceItemRepository;
    private final AttendanceItemRequestConverter requestConverter;
    private final AttendanceItemResponseConverter responseConverter;
    private final StudentRepository studentRepository;
    private final LessonEventRepository lessonEventRepository;

    @Override
    public AttendanceItemResponse getAttendanceItem(Long id) {
        return attendanceItemRepository.findById(id)
                .map(responseConverter)
                .orElseThrow(() -> new RecordNotFoundException("AttendanceItem not found with id: " + id));
    }

    @Override
    public List<AttendanceItemResponse> getAttendanceItems() {
        return attendanceItemRepository.findAll()
                .stream()
                .map(responseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceItemResponse save(AttendanceItemRequest request) {
        AttendanceItem item = requestConverter.apply(request);
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RecordNotFoundException("Student not found with id: " + request.getStudentId()));
        LessonEvent lessonEvent = lessonEventRepository.findById(request.getLessonEvent())
                .orElseThrow(() -> new RecordNotFoundException("LessonEvent not found with id: " + request.getLessonEvent()));
        item.setLessonEvent(lessonEvent);
        item.setStudent(student);
        return responseConverter.apply(attendanceItemRepository.save(item));
    }

    @Override
    public AttendanceItemResponse update(Long id, AttendanceItemRequest request) {
        if (existsById(id)) {
            request.setId(id);
            return save(request);
        } else {
            throw new RecordNotFoundException("AttendanceItem not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (existsById(id)) {
            attendanceItemRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("AttendanceItem not found with id: " + id);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return attendanceItemRepository.existsById(id);
    }
}

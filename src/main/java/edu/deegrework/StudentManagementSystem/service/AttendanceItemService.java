package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;

import java.util.List;

public interface AttendanceItemService {

    AttendanceItemResponse getAttendanceItem(Long id);

    List<AttendanceItemResponse> getAttendanceItems();

    List<AttendanceItemResponse> getAttendanceItemsByLessonId(Long lessonId);

    List<AttendanceItemResponse> saveAll(List<AttendanceItemRequest> request);

    AttendanceItemResponse save(AttendanceItemRequest request);

    AttendanceItemResponse update(Long id, AttendanceItemRequest facultyRequest);

    void delete(Long id);

    boolean existsById(Long id);
}

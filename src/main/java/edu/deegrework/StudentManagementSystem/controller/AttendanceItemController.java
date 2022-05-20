package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
import edu.deegrework.StudentManagementSystem.service.AttendanceItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(path = "/attendanceItems", produces = "application/json")
public class AttendanceItemController {

    private final AttendanceItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AttendanceItemResponse> getAttendanceItems(){
        return itemService.getAttendanceItems();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AttendanceItemResponse getAttendanceItem(@PathVariable Long id){
        return itemService.getAttendanceItem(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceItemResponse save(@RequestBody AttendanceItemRequest request){
        return itemService.save(request);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AttendanceItemResponse update(@PathVariable Long id,
                                         @RequestBody AttendanceItemRequest request){
        return itemService.update(id, request);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        itemService.delete(id);
    }
}

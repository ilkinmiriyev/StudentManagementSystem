package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.AttendanceItemRequest;
import edu.deegrework.StudentManagementSystem.response.AttendanceItemResponse;
import edu.deegrework.StudentManagementSystem.service.AttendanceItemService;
import edu.deegrework.StudentManagementSystem.validation.ValidateRequestBodyList;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(path = "/v1/attendanceItems", produces = "application/json")
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
    public List<AttendanceItemResponse> save(@RequestBody
                                             @Valid
                                             ValidateRequestBodyList<AttendanceItemRequest> request){
        return itemService.saveAll(request.getRequestBody());
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AttendanceItemResponse update(@PathVariable Long id,
                                         @RequestBody @Valid AttendanceItemRequest request){
        return itemService.update(id, request);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        itemService.delete(id);
    }
}

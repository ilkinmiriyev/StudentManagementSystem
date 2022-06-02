package edu.deegrework.StudentManagementSystem.controller;

import edu.deegrework.StudentManagementSystem.request.LessonEventRequest;
import edu.deegrework.StudentManagementSystem.response.LessonEventResponse;
import edu.deegrework.StudentManagementSystem.service.LessonEventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(path = "v1/lessonEvents", produces = "application/json")
public class LessonEventController {

        private final LessonEventService eventService;

        @GetMapping(path = "/{id}")
        @ResponseStatus(HttpStatus.OK)
        public LessonEventResponse getLessonEvent(@PathVariable Long id){
            return eventService.getLessonEvent(id);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<LessonEventResponse> getLessonEvents(){
            return eventService.getLessonEvents();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public LessonEventResponse save(@RequestBody LessonEventRequest request){
            return eventService.save(request);
        }

//        @GetMapping("/teamIdAndSubjectId")
//        @ResponseStatus(HttpStatus.OK)
//        public List<LessonEventResponse> getLessonEventByTeamIdAndSubjectId(
//                @RequestParam(name = "teamId") Long teamId,
//                @RequestParam(name = "subjectId") Long subjectId){
//
//
//                return eventService.getEventByTeamIdAndSubjectId(teamId, subjectId);
//        }

        @PutMapping(path = "/{id}")
        @ResponseStatus(HttpStatus.OK)
        public LessonEventResponse update(@PathVariable Long id,
                                          @RequestBody LessonEventRequest request){
            return eventService.update(id, request);
        }

        @DeleteMapping(path = "/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id){
            eventService.delete(id);
        }
}

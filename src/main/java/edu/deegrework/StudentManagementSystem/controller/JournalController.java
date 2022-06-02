//package edu.deegrework.StudentManagementSystem.controller;
//
//import edu.deegrework.StudentManagementSystem.request.JournalRequest;
//import edu.deegrework.StudentManagementSystem.response.JournalResponse;
//import edu.deegrework.StudentManagementSystem.service.JournalService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@AllArgsConstructor
//@RequestMapping(path = "v1/journals", produces = "application/json")
//public class JournalController {
//
//    private final JournalService journalService;
//
//    @GetMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public JournalResponse getJournal(@PathVariable Long id){
//        return journalService.getJournal(id);
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<JournalResponse> getJournals(){
//        return journalService.getJournals();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public JournalResponse save(@RequestBody JournalRequest request){
//        return journalService.save(request);
//    }
//
//    @PutMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public JournalResponse update(@PathVariable Long id,
//                                  @RequestBody JournalRequest request){
//        return journalService.update(id, request);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id){
//        journalService.delete(id);
//    }
//}

package edu.deegrework.StudentManagementSystem.request;

import edu.deegrework.StudentManagementSystem.exception.RecordNotFoundException;
import edu.deegrework.StudentManagementSystem.model.Student;
import edu.deegrework.StudentManagementSystem.model.Team;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class StudentRequestConverter implements Function<StudentRequest, Student> {
//
//    @Autowired
//    private TeamRepository teamRepository;

    @Override
    public Student apply(StudentRequest studentRequest) {

        if (studentRequest==null){
            return null;
        }

//        Team team = teamRepository.findById(studentRequest.getTeamId())
//                .orElseThrow(()->new RecordNotFoundException("Team not found this id :: "+studentRequest.getTeamId()));


        return Student.builder()
                .academicDegree(studentRequest.getAcademicDegree())
                .birthdate(studentRequest.getBirthdate())
                .id(studentRequest.getId())
                .course(studentRequest.getCourse())
                .email(studentRequest.getEmail())
                .firstName(studentRequest.getFirstname())
                .phone(studentRequest.getPhone())
                .lastName(studentRequest.getLastname())
//                .team(team)
//                .password(studentRequest.getPassword())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.response;

import edu.deegrework.StudentManagementSystem.model.Student;

import java.util.function.Function;

public class StudentResponseConverter implements Function<Student, StudentResponse> {

    @Override
    public StudentResponse apply(Student student) {

        return StudentResponse.builder()
                .id(student.getId())
                .firstname(student.getFirstName())
                .lastname(student.getLastName())
                .birthdate(student.getBirthdate())
                .email(student.getEmail())
                .phone(student.getPhone())
                .academicDegree(student.getAcademicDegree())
                .course(student.getCourse())
                .build();
    }
}

package edu.deegrework.StudentManagementSystem.model;

public enum Semester {
    FIRST(Course.FIRST),
    SECOND(Course.FIRST),
    THIRD(Course.SECOND),
    FOURTH(Course.SECOND),
    FIFTH(Course.THIRD),
    SIXTH(Course.THIRD),
    SEVENTH(Course.FOURTH),
    EIGHTH(Course.FOURTH);

    private final Course course;

    Semester(Course course) {
        this.course = course;
    }
}

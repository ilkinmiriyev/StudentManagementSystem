package edu.deegrework.StudentManagementSystem.enumaration;

public enum Course {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4);

    private Integer course;

    Course (Integer course){
        this.course=course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                '}';
    }
}

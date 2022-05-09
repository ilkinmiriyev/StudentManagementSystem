package edu.deegrework.StudentManagementSystem.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance_item")
public class AttendanceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lessonEvent_id", referencedColumnName = "id")
    private LessonEvent lessonEvent;

    @Column(name = "status")
    private Boolean status;
}




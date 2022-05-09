package edu.deegrework.StudentManagementSystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_event")
@Entity
public class LessonEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @OneToMany(mappedBy = "lessonEvent", cascade = CascadeType.ALL)
    private List<AttendanceItem> attendanceItems;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @Column(name = "date")
    private Date date;

}

package edu.deegrework.StudentManagementSystem.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_event")
@Entity
public class LessonEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name="subject_id", referencedColumnName = "id")
    private SubjectEntity subject;

    @Column(name = "lesson_date")
    private Date lessonDate;

    @Column(name = "date", insertable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "date", insertable = false, updatable = false)
    @UpdateTimestamp
    private Date updatedAt;
}

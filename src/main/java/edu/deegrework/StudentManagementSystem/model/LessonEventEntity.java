package edu.deegrework.StudentManagementSystem.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @OneToMany(mappedBy = "lesson")
    private List<ScoreEntity> scores;

    @Column(name = "lesson_date")
    private Date lessonDate;

    @Column(name = "createdAt", insertable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updatedAt", insertable = false, updatable = false)
    @UpdateTimestamp
    private Date updatedAt;
}

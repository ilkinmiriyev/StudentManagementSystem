package edu.deegrework.StudentManagementSystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private JournalEntity journal;

    @OneToMany(mappedBy = "team")
    List<LessonEventEntity> lessonEvents;

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private SpecializationEntity specialization;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<StudentEntity> students;

    @ManyToMany(mappedBy = "teams")
    private List<TeacherEntity> teachers;
}

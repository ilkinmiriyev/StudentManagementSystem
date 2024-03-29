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
@Table(name="subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(name = "specialization_subject",
            joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id", referencedColumnName = "id"))
    private List<SpecializationEntity> specializations;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<TopicEntity> topics;

    @OneToMany(mappedBy = "subject")
    private List<TeacherEntity> teachers;

    @OneToMany(mappedBy = "subject")
    private List<LessonEventEntity> lessonEvent;
}

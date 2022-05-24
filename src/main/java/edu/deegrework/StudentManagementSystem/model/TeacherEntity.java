package edu.deegrework.StudentManagementSystem.model;

import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
@Entity
public class TeacherEntity {      // className: TeacherEntity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private CustomUserDetails userDetails;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastname;

//    @OneToMany(mappedBy = "teacher")
//    private List<LessonEventEntity> events;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private SubjectEntity subject;

    @ManyToMany
    @JoinTable(name = "teacher_teams",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id")
    )
    private List<TeamEntity> teams;
}
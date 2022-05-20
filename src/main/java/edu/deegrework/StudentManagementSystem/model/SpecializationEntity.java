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
@Table(name="specialization")

public class SpecializationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "specializations", cascade = CascadeType.ALL)
    private List<SubjectEntity> subjects;

    @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL)
    private List<TeamEntity> teams;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private FacultyEntity faculty;
}

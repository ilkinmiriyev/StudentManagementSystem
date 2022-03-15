package edu.deegrework.StudentManagementSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<Specialization> specializations;

    @ManyToOne
    @JoinColumn(name = "univsersity_id", referencedColumnName = "id")
    private University university;

}

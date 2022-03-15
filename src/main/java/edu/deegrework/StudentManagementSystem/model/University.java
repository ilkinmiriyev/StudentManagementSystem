package edu.deegrework.StudentManagementSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "university")
    private List<Faculty> faculties;


}

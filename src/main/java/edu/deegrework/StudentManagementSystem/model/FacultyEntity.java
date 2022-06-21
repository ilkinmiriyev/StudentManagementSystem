package edu.deegrework.StudentManagementSystem.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="faculty")
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<SpecializationEntity> specializations;

    @Column(name = "creation_date", updatable = false, nullable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private UniversityEntity university;
}

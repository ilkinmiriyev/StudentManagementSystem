package edu.deegrework.StudentManagementSystem.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subject")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Team> teams;

//    @JsonBackReference
    @ManyToMany(mappedBy = "subjects")
    private List<Specialization> specializations;

    @OneToMany(mappedBy = "subject")
    private List<Topic> topics;

}

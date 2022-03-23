package edu.deegrework.StudentManagementSystem.model;


import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
@SQLDelete(sql = "update student SET deleted = true where id=?")
@Where(clause = "deleted = false")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthdate")
    private Date birthdate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Team team;

    @Column(name = "academicDegree")
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Column(name="course")
    @Enumerated(EnumType.ORDINAL)
    private Course course;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "creation_date", updatable = false, nullable = false)
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "password")
    private String password;
}

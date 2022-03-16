package edu.deegrework.StudentManagementSystem.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @ManyToOne(/*fetch = FetchType.EAGER*/)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @Column(name = "academicDegree")
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Column(name="course")
    @Enumerated(EnumType.ORDINAL)
    private Course course;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "creation_date", insertable = false, nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "password")
    private String password;
}

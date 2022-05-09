package edu.deegrework.StudentManagementSystem.model;


import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private CustomUserDetails userDetails;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthdate")
    private Date birthdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Team team;

    @Column(name = "academicDegree")
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Column(name="semester")
    @Enumerated(EnumType.ORDINAL)
    private Semester semester;

    @OneToMany(mappedBy = "student")
    private List<AttendanceItem> itemList;

    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;

    @Column(name = "lesson_limit")
    private Integer lessonLimit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

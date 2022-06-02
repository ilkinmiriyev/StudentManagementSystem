//package edu.deegrework.StudentManagementSystem.model;
//
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Setter
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "attendance_item")
//public class AttendanceItemEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private StudentEntity student;
//
//    @ManyToOne
//    @JoinColumn(name = "lessonEvent_id", referencedColumnName = "id")
//    private LessonEventEntity lessonEvent;
//
//    @OneToMany(mappedBy = "attendanceItem", cascade = CascadeType.ALL)
//    private List<ScoreEntity> score;
//
//    @Column(name = "date", insertable = false, updatable = false)
//    @CreationTimestamp
//    private Date createdAt;
//
//    @Column(name = "date")
//    @UpdateTimestamp
//    private Date updatedAt;
//}
//
//
//

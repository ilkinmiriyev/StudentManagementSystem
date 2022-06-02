//package edu.deegrework.StudentManagementSystem.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Setter
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "journal")
//@Entity
//public class JournalEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "id")
//    private TeamEntity team;
//
////    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL)
////    private List<LessonEvent> lessonEvents;
//}
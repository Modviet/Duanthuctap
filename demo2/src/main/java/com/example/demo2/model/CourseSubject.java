package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Coursesubject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course CourseId;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject SubjectId;
}

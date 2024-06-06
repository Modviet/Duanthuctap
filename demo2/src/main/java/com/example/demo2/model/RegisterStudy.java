package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Registerstudy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User UserId;

    @ManyToOne
    @JoinColumn(name ="courseId")
    private Course CourseId;

    @ManyToOne
    @JoinColumn(name ="crouseSubjectId")
    private CourseSubject CourseSubjectId;

    private Boolean IsFinished;
    private LocalDate RegisterTime;
    private int PercentComplete;
    private LocalDate DoneTime;
    private Boolean IsActive;

}

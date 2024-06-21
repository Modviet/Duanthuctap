package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Leanringprogress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LearningProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "registerStudyId")
    private RegisterStudy RegisterStudyId;

    @ManyToOne
    @JoinColumn(name = "SubjectId")
    private Subject CurrentSubjectId;
}

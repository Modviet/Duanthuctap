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
    @JoinColumn(name = "Id")
    private User UserId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private RegisterStudy RegisterStudyId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Subject CurrentSubjectId;
}

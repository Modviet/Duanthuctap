package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Practice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private SubjectDetail SubjectDetailId;

    private String Level;

    private String PracticeCode;
    private String Title;
    private String Topic;
    private String ExpectOutput;

    @ManyToOne
    @JoinColumn(name = "Id")
    private ProgramingLanguage LanguageProgramingId;

    private Boolean IsRequired;
    private LocalDate CreateTime;
    private LocalDate UpdateTime;

    private Boolean IsDeleted;
    private Double MediumScore;
}

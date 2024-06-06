package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Testcase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Input;
    private String Outputl;

    @ManyToOne
    @JoinColumn(name = "programingLanguageId")
    private ProgramingLanguage ProgramingLanguageId;

    @ManyToOne
    @JoinColumn(name = "practiceId")
    private Practice PracticeId;

}

package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private MakeQuestion QuestionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User UserId;

    private String Answer;
    private LocalDate CreateTime;
    private LocalDate UpdateTime;
}

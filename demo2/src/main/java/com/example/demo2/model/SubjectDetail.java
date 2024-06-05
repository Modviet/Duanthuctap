package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Subjectdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Subject SubjectId;

    private String Name;
    private Boolean IsFinished;
    private String LinkVideo;
    private Boolean IsActive;
}

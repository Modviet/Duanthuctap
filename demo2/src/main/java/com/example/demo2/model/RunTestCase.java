package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Runtestcase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunTestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private DoHomework DoHomeworkId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private TestCase TestCaseId;

    protected String Result;
    private Double RunTime;
}

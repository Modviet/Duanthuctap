package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Entity
@Table(name = "Course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Name;
    private String Introduce;
    private String ImageCourse;
    private int CreatorId;

    private String Code;
    private double Price;

    private int TotalCourseDuration;
    private int NumberOfStudent;
    private int NumberOfPurchases;

}

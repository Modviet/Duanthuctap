package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private User CreatorId;

    private String Content;
    private String Title;
    private int NumberOfLike;
    private int NumberOfComments;

    private LocalDate CreateTime;
    private LocalDate UpdateTime;

}

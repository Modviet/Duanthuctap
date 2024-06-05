package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Likeblog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private User UserId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Blog BlogId;

    private Boolean Unlike;

    private LocalDate CreateTime;
    private LocalDate UpdateTime;
}

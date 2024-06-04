package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private User UserId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Course CoursId;

    private double Price;

    private String TradingCode;

    private LocalDate CreateTime;

    @ManyToOne
    @JoinColumn(name = "Id")
    private BillStatus BillStatusId;

}

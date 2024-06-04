package com.example.demo2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "District")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name="Id")
    private Province ProvinceId;

    private String Name;
}

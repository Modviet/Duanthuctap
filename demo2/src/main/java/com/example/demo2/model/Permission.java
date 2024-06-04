package com.example.demo2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private User UserId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Role RoleId;

}

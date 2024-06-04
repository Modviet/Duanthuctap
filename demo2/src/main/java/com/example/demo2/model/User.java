package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Username;
    private LocalDate CreateTime;
    private String Avatar;
    private String Email;
    private LocalDate UpdateTime;
    private String Password;
    private String FullName;
    private LocalDate DateOfBirth;
    private Boolean IsActive;
    private String Address;

    @ManyToOne
    @JoinColumn(name = "Id")
    private District DistrictId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Province ProvinceId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Certificate CertificateId;

    private String UserStatus;

}

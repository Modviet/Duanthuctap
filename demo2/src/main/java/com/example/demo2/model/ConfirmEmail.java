package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "Confirmemail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String ConfirmCode;
    private LocalDate ExpiryTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User UserId;

    private boolean IsConfirm;
}

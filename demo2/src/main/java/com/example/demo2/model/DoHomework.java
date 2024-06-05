package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="Dohomework")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoHomework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Practice PracticeId;

    @ManyToOne
    @JoinColumn(name = "Id")
    private User UserId;
    private enum HomeworkStatus {
        CHUA_LAM("chua lam"),
        DA_LAM("da lam"),
        SAI("sai"),
        DUNG("dung");
        private final String trangthai;

        HomeworkStatus(String trangthai){
            this.trangthai = trangthai;
        }

    }
    private Boolean IsFinished;

    private String ActualOutput;
    private LocalDate DoneTime;

    @ManyToOne
    @JoinColumn(name = "Id")
    private RegisterStudy RegisterStudyId;

}

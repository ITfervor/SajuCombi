package com.example.sajucombi.sajuinfo.entity;

import jakarta.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SajuDb")
public class SajuDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apiId")
    private Long apiId;

//    @Column(name = "lunAmount")
//    private String lunAmount;

    @Column(name = "lunYear")
    private Long lunYear;

    @Column(name = "lunMonth")
    private Long lunMonth;

    @Column(name = "lunDay")
    private Long lunDay;

    @Column(name = "lunWolgeon")
    private String lunWolgeon;

    @Column(name = "lunSecha")
    private String lunSecha;

    @Column(name = "lunIljin")
    private String lunIljin;

}

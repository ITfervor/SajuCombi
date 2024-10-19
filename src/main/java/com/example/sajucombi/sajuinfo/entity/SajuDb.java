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

    @Column(name = "solYear")
    private Long solYear;

    @Column(name = "solMonth")
    private Long solMonth;

    @Column(name = "solDay")
    private Long solDay;

    @Column(name = "lunWolgeon")
    private String lunWolgeon;

    @Column(name = "lunSecha")
    private String lunSecha;

    @Column(name = "lunIljin")
    private String lunIljin;

}

package com.example.sajucombi.sajuinfo.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SajuResult")
public class SajuResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "id")
    private User id;

    @Column(name ="lunIljinId")
    @OneToOne
    @JoinColumn(name = "lunIljinId")
    private SajuInfo lunIljinId;

    @Column(name = "lunIljin")
    private String lunIljin;

    @Column(name = "name")
    private String name;

    @Column(name = "lunYear")
    private String lunYear;

    @Column(name = "lunMonth")
    private String lunMonth;

    @Column(name ="lunDay")
    private String lunDay;

    @Column(name = "lunSecha")
    private String lunSecha;

    @Column(name = "lunWolgen")
    private String lunWolgen;

}

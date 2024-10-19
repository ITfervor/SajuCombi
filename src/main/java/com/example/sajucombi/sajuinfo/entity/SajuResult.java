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

    @Column(name = "solYear")
    private String solYear;

    @Column(name = "solMonth")
    private String solMonth;

    @Column(name ="solDay")
    private String solDay;

    @Column(name = "lunSecha")
    private String lunSecha;

    @Column(name = "lunWolgen")
    private String lunWolgen;

}

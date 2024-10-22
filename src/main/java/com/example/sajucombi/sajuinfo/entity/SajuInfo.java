package com.example.sajucombi.sajuinfo.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "SajuInfo")
public class SajuInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lunIljinId")
    private Long lunIljinId;

    @Column(name = "lunIljin")
    private String lunIljin;

    @Column(name = "summary")
    private String summary;

    @Column(name = "correctType")
    private String correctType;

    @Column(name = "incorrectType")
    private String incorrectType;

    @Column(name="cInnerType")
    private String cInnerType;

    @Column(name="incInnerType")
    private String incInnerType;

    @Column(name="sajuImage")
    private String sajuImage;

}

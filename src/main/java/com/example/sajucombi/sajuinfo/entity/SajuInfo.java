package com.example.sajucombi.sajuinfo.entity;

import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoUpdateRequesetDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


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

    public void updateSajuInfo(SajuInfoUpdateRequesetDTO sajuInfoUpdateRequesetDTO) {
        this.lunIljin = sajuInfoUpdateRequesetDTO.getLunIljin();
        this.summary = sajuInfoUpdateRequesetDTO.getSummary();
        this.correctType = sajuInfoUpdateRequesetDTO.getCorrectType();
        this.incorrectType = sajuInfoUpdateRequesetDTO.getIncorrectType();
        this.cInnerType = sajuInfoUpdateRequesetDTO.getCInnerType();
        this.incInnerType = sajuInfoUpdateRequesetDTO.getIncInnerType();
    }
}

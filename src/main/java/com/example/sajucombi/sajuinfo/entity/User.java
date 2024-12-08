package com.example.sajucombi.sajuinfo.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor //파라미터가 있는 생성자 형성
@NoArgsConstructor // 파라미터가 없는 생성자 형성
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    //외래키로 연결해야하니까 한번 확인
    @Column(name = "lunIljin")
    private String lunIljin;

    @Column(name = "name")
    private String name;

    @Column(name = "solYear")
    private Long solYear;

    @Column(name = "solMonth")
    private Long solMonth;

    @Column(name = "solDay")
    private Long solDay;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

//    @Column(name = "calculate")
//    private Long calculate;


}

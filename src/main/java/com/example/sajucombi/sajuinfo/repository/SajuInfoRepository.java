package com.example.sajucombi.sajuinfo.repository;

import com.example.sajucombi.sajuinfo.entity.SajuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SajuInfoRepository extends JpaRepository<SajuInfo, Long> {
    Optional<SajuInfo> findSajuInfoByLunIljinIdAndLunIljin(Long lunIljinId, String lunIljin);

}

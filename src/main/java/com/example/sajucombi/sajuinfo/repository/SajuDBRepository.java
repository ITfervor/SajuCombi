package com.example.sajucombi.sajuinfo.repository;

import com.example.sajucombi.sajuinfo.entity.SajuDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SajuDBRepository extends JpaRepository<SajuDb, Long> {
    Optional<SajuDb> findBySolYearAndSolMonthAndSolDay(Long solYear, Long solMonth, Long solDay);

}

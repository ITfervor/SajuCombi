package com.example.sajucombi.sajuinfo.repository;

import com.example.sajucombi.sajuinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<User, Long> {
}

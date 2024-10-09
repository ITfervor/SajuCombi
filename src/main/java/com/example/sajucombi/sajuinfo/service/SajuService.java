package com.example.sajucombi.sajuinfo.service;

import com.example.sajucombi.sajuinfo.repository.SajuInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface SajuService {
//    private final SajuInfoRepository sajuInfoRepository;

    @Transactional
    UserInfoResponseDTO UserSave(UserInfoRequestDTO userInfoRequestDTO);


}

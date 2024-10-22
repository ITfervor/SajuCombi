package com.example.sajucombi.sajuinfo.service;

import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoRequestDTO;
import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoUpdateRequesetDTO;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoUpdateResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoSaveResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public interface SajuService {
//    private final SajuInfoRepository sajuInfoRepository;

    @Transactional
    UserInfoSaveResponseDTO UserSave(UserInfoSaveRequestDTO userInfoSaveRequestDTO);

    @Transactional
    SajuInfoResponseDTO InfoDetail(SajuInfoRequestDTO sajuInfoRequestDTO);

    @Transactional
    SajuInfoUpdateResponseDTO InfoUpdate(SajuInfoUpdateRequesetDTO sajuInfoUpdateRequesetDTO);

}

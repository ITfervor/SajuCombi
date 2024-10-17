package com.example.sajucombi.sajuinfo.service;

import com.example.sajucombi.sajuinfo.repository.SajuInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SajuServiceImpl implements SajuService {
    private final SajuInfoRepository sajuInfoRepository;
    String lunIljin;
    //해당 부분을 통해 Info에 대해서 저장하고 그리고 성공에 대해 리턴 및 string을 반환해서 해당 반환하는 값을 또 sajuresult에 접근하는 방향으로 생각
    @Override
    public UserInfoResponseDTO UserSave(UserInfoRequestDTO userInfoRequestDTO){
        try{

            lunIljin = sajuInfoRepository.save();

            return UserInfoResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.OK))
                    .msg("User Save Succesefully")
                    .build();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return UserInfoResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.EXPECTATION_FAILED))
                    .msg("User Save Fail")
                    .build();
        }

    }


}

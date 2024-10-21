package com.example.sajucombi.sajuinfo.service;

import com.example.sajucombi.sajuinfo.entity.SajuDb;
import com.example.sajucombi.sajuinfo.entity.User;
import com.example.sajucombi.sajuinfo.repository.SajuDBRepository;
import com.example.sajucombi.sajuinfo.repository.SajuInfoRepository;
import com.example.sajucombi.sajuinfo.repository.UserInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class SajuServiceImpl implements SajuService {

    private final SajuInfoRepository sajuInfoRepository;
    private final UserInfoRepository userInfoRepository;
    private final SajuDBRepository sajuDBRepository;


    //user정보에 대해서 저장하는 메서드
    @Override
    public UserInfoResponseDTO UserSave(UserInfoRequestDTO userInfoRequestDTO){
        try{
            //생년월일을 통해서 년주,월주,일주 불러오기
            String lunIljin = getLunIljin(userInfoRequestDTO.getSolYear(), userInfoRequestDTO.getSolMonth(), userInfoRequestDTO.getSolDay());

            if(lunIljin == "No Data"){
                throw new NoSuchElementException("No data found for the given date.");
            }

            //repository를통한 save
            User user = User.builder()
                    .name(userInfoRequestDTO.getName())
                    .solYear(userInfoRequestDTO.getSolYear())
                    .solMonth(userInfoRequestDTO.getSolMonth())
                    .solDay(userInfoRequestDTO.getSolDay())
                    .gender(userInfoRequestDTO.getGender())
                    .address(userInfoRequestDTO.getAddress())
                    .lunIljin(lunIljin)
                    .build();
            

            //user에 대한 정보 조회해서 제대로 입력이 되었는지 확인 
            Long userIdResult = userInfoRepository.save(user).getId();
            
            return UserInfoResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.OK))
                    .msg("User Save Succesefully")
                    .userId(userIdResult)
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

    //일주 가져오는 메서드
    public String getLunIljin(Long solYear, Long solMonth, Long solDay) {
        // 데이터베이스에서 SajuDb를 조회하여 lunIljin 반환
        Optional<SajuDb> sajuDbOptional = sajuDBRepository.findBySolYearAndSolMonthAndSolDay(solYear, solMonth, solDay);

        if (sajuDbOptional.isPresent()) {
            return sajuDbOptional.get().getLunIljin();
        } else {
            return "No Data";
        }
    }


}

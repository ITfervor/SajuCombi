package com.example.sajucombi.sajuinfo.service;

import com.example.sajucombi.sajuinfo.entity.SajuDb;
import com.example.sajucombi.sajuinfo.entity.SajuInfo;
import com.example.sajucombi.sajuinfo.entity.User;
import com.example.sajucombi.sajuinfo.repository.SajuDBRepository;
import com.example.sajucombi.sajuinfo.repository.SajuInfoRepository;
import com.example.sajucombi.sajuinfo.repository.UserInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoRequestDTO;
import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoUpdateRequesetDTO;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoUpdateResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoSaveResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
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
    @Transactional
    public UserInfoSaveResponseDTO UserSave(UserInfoSaveRequestDTO userInfoSaveRequestDTO){
        try{
            //생년월일을 통해서 년주,월주,일주 불러오기
            String lunIljin = getLunIljin(userInfoSaveRequestDTO.getSolYear(), userInfoSaveRequestDTO.getSolMonth(), userInfoSaveRequestDTO.getSolDay());

            if(lunIljin == "No Data"){
                throw new NoSuchElementException("No data found for the given date.");
            }

            //repository를통한 save
            User user = User.builder()
                    .name(userInfoSaveRequestDTO.getName())
                    .solYear(userInfoSaveRequestDTO.getSolYear())
                    .solMonth(userInfoSaveRequestDTO.getSolMonth())
                    .solDay(userInfoSaveRequestDTO.getSolDay())
                    .gender(userInfoSaveRequestDTO.getGender())
                    .address(userInfoSaveRequestDTO.getAddress())
                    .lunIljin(lunIljin)
                    .build();
            

            //user에 대한 정보 조회해서 제대로 입력이 되었는지 확인 
            Long userIdResult = userInfoRepository.save(user).getId();
            
            return UserInfoSaveResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.OK))
                    .msg("User Save Succesefully")
                    .userId(userIdResult)
                    .build();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return UserInfoSaveResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.EXPECTATION_FAILED))
                    .msg("User Save Fail")
                    .build();
        }

    }

    //내가 요약한 사주에 대한 정보 Read
    //사용자 등록과 동시에 사용자의 일주가 sajuInfoRequestDTO에 담겨서 보내기
    @Override
    public SajuInfoResponseDTO InfoDetail(SajuInfoRequestDTO sajuInfoRequestDTO){

        //case문에 따라서 sajuInfoRequestDTO.getLunIljin에 넣는것도 생각하기
        SajuInfo sajuInfo = sajuInfoRepository.findSajuInfoByLunIljinIdAndLunIljin(sajuInfoRequestDTO.getLunIljinId(), sajuInfoRequestDTO.getLunIlJin())
                .orElseThrow(() -> new NoSuchElementException("No data found for given criteria"));

        return SajuInfoResponseDTO.builder()
                .lunIljinId(sajuInfo.getLunIljinId())
                .lunIljin(sajuInfo.getLunIljin())
                .summary(sajuInfo.getSummary())
                .correctType(sajuInfo.getCorrectType())
                .incorrectType(sajuInfo.getIncorrectType())
                .CInnerType(sajuInfo.getCInnerType())
                .IncInnerType(sajuInfo.getIncInnerType())
                .sajuImage(sajuInfo.getSajuImage())
                .build();
    }


    @Transactional
    //사주 정보 업데이트 할때 사용하는 함수 -> 관리자 권한에서만 이용이 가능하도록 방안 생각 빌더 패턴 이용
    public SajuInfoUpdateResponseDTO InfoUpdate(SajuInfoUpdateRequesetDTO sajuInfoUpdateRequesetDTO){

        try{

            SajuInfo sajuInfo = sajuInfoRepository.findById(sajuInfoUpdateRequesetDTO.getLunIljinId()).orElseThrow(NullPointerException::new);;
            sajuInfo.updateSajuInfo(sajuInfoUpdateRequesetDTO);
            sajuInfoRepository.save(sajuInfo);

            return SajuInfoUpdateResponseDTO.builder()
                    .code(String.valueOf(HttpStatus.OK))
                    .msg("SajuInfo Update Succesefully")
                    .build();

        }
        catch (Exception e){
            System.out.println(e.toString());
            return SajuInfoUpdateResponseDTO.builder( )
                    .code(String.valueOf(HttpStatus.EXPECTATION_FAILED))
                    .msg("SajuInfo Update Fail")
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

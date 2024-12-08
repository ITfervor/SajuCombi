package com.example.sajucombi.sajuinfo.controller;

import com.example.sajucombi.sajuinfo.requestDTO.SajuInfoRequestDTO;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.SajuInfoResponseDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoSaveResponseDTO;
import com.example.sajucombi.sajuinfo.service.SajuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Validated
@RequiredArgsConstructor
@RestController
public class SajuController {
    private SajuService sajuService;

    //main home 출력하는 도메인
//    @GetMapping("/saju/home")


    @PostMapping("/saju/register")
    public ResponseEntity<UserInfoSaveResponseDTO> register(@Valid @RequestBody UserInfoSaveRequestDTO userInfoSaveRequestDTO){
        try{
            UserInfoSaveResponseDTO userInfoSaveResponseDTO = sajuService.UserSave(userInfoSaveRequestDTO);

            return ResponseEntity.status(HttpStatus.OK).body(userInfoSaveResponseDTO);
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    //결과값 출력해주는 컨트롤러
//    @PostMapping("/saju/result")
//    public ResponseEntity<SajuInfoResponseDTO> result(){
//        return ResponseEntity.status(HttpStatus.OK).body(SajuInfoResponseDTO);
//    }
}

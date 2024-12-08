package com.example.sajucombi.service;

import com.example.sajucombi.sajuinfo.entity.SajuDb;
import com.example.sajucombi.sajuinfo.entity.User;
import com.example.sajucombi.sajuinfo.repository.SajuDBRepository;
import com.example.sajucombi.sajuinfo.repository.UserInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoSaveResponseDTO;
import com.example.sajucombi.sajuinfo.service.SajuServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SajuServiceTest {

    @InjectMocks
    private SajuServiceImpl sajuService; // 테스트할 실제 서비스 클래스

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private SajuDBRepository sajuDBRepository;

    public SajuServiceTest() {
        MockitoAnnotations.openMocks(this); // Mock 객체 초기화
    }

    @Test
    public void testUserSave_Success() {
        // Arrange: 테스트 데이터를 준비
        UserInfoSaveRequestDTO saveRequestDTO = UserInfoSaveRequestDTO.builder()
                .name("이정엽")
                .solYear(1997L)
                .solMonth(4L)
                .solDay(22L)
                .gender("남")
                .address("성남시 분당구")
                .build();

        SajuDb mockSajuDb = new SajuDb();
        mockSajuDb.setLunIljin("갑자");

        User mockUser = User.builder()
                .userId(1L)
                .name("이정엽")
                .solYear(1997L)
                .solMonth(4L)
                .solDay(22L)
                .gender("남")
                .address("성남시 분당구")
                .lunIljin("갑자")
                .build();

        // Mock SajuDBRepository 동작 설정
        when(sajuDBRepository.findBySolYearAndSolMonthAndSolDay(1997L, 4L, 22L))
                .thenReturn(Optional.of(mockSajuDb));

        // Mock UserInfoRepository 동작 설정
        when(userInfoRepository.save(any(User.class))).thenReturn(mockUser);

        // Act: 서비스 메서드 호출
        UserInfoSaveResponseDTO response = sajuService.UserSave(saveRequestDTO);

        // Assert: 결과 검증
        assertEquals(String.valueOf(HttpStatus.OK), response.getCode());
        assertEquals("User Save Succesefully", response.getMsg());
        assertEquals(1L, response.getUserId());
    }

    @Test
    public void testUserSave_NoData() {
        // Arrange: 잘못된 날짜를 가진 DTO 생성
        UserInfoSaveRequestDTO saveRequestDTO = UserInfoSaveRequestDTO.builder()
                .name("이정엽")
                .solYear(1997L)
                .solMonth(4L)
                .solDay(23L) // 잘못된 날짜로 설정
                .gender("남")
                .address("성남시 분당구")
                .build();

        // Mock SajuDBRepository 동작 설정 (데이터 없음)
        when(sajuDBRepository.findBySolYearAndSolMonthAndSolDay(1997L, 4L, 23L))
                .thenReturn(Optional.empty());

        // Act: 서비스 메서드 호출
        UserInfoSaveResponseDTO response = sajuService.UserSave(saveRequestDTO);

        // Assert: 결과 검증
        assertEquals(String.valueOf(HttpStatus.EXPECTATION_FAILED), response.getCode());
        assertEquals("User Save Fail", response.getMsg());
    }
}

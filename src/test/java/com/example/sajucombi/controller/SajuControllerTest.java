package com.example.sajucombi.controller;

import com.example.sajucombi.sajuinfo.controller.SajuController;
import com.example.sajucombi.sajuinfo.entity.User;
import com.example.sajucombi.sajuinfo.repository.UserInfoRepository;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.responseDTO.UserInfoSaveResponseDTO;
import com.example.sajucombi.sajuinfo.service.SajuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@ExtendWith(SpringExtension.class)
@WebMvcTest(SajuController.class)
@WithMockUser(roles = "USER")
public class SajuControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SajuService sajuService;

    @MockBean
    private UserInfoRepository userInfoRepository;

    @Test
    public void registerUser() throws Exception{
        UserInfoSaveRequestDTO saveRequestDTO = UserInfoSaveRequestDTO.builder()
                .name("이정엽")
                .solYear(1997L)
                .solMonth(04L)
                .solDay(22L)
                .gender("남")
                .address("성남시 분당구")
                .build();

        System.out.println(saveRequestDTO);
         UserInfoSaveResponseDTO saveResponseDTO = UserInfoSaveResponseDTO.builder()
                .code(String.valueOf(HttpStatus.OK))
                .msg("정상적으로 문제를 생성하였습니다.")
                .userId(1L)  // userId에 값을 명시적으로 설정합니다.
                .build();
        
        System.out.println(saveResponseDTO);

        given(sajuService.UserSave(any(UserInfoSaveRequestDTO.class))).willReturn(saveResponseDTO);
//        given(userInfoRepository.save(any(User.class))).willReturn(new User(1L, "갑오","이정엽", 1997L, 4L, 22L, "남", "성남시 분당구"));

//        mockMvc.perform(post("/saju")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(saveRequestDTO)))
//                .andExpect(status().isOk());


    }

}

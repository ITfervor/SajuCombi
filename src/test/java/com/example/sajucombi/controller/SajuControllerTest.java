package com.example.sajucombi.controller;

import com.example.sajucombi.sajuinfo.controller.SajuController;
import com.example.sajucombi.sajuinfo.requestDTO.UserInfoSaveRequestDTO;
import com.example.sajucombi.sajuinfo.service.SajuService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureRestDocs
@ExtendWith(SpringExtension.class)
@WebMvcTest(SajuController.class)
@WithMockUser(roles = "USER")
public class SajuControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SajuService sajuService;

    @Test
    public void registerUser() throws Exception{
        UserInfoSaveRequestDTO SaveRequestDTO = UserInfoSaveRequestDTO.builder()
                .name("이정엽")
                .solYear(1997L)
                .solMonth(04L)
                .solDay(22L)
                .gender("남")
                .address("성남시 분당구")
                .build();
    }

}

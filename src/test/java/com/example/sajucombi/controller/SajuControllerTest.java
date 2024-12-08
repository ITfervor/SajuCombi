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


}

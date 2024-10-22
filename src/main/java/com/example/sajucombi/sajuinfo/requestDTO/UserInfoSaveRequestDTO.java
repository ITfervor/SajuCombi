package com.example.sajucombi.sajuinfo.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



//사용자의 정보를 저장하기 위한 DTO
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserInfoSaveRequestDTO {

    private Long userId;

    @NotBlank(message = "이름을 기입해주세요")
    private String name;

    @NotNull(message = "태어난 년도를 기입해주세요")
    private Long solYear;

    @NotNull(message = "태어난 월을 기입해주세요")
    private Long solMonth;

    @NotNull(message = "태어난 일을 기입해주세요")
    private Long solDay;

    @NotBlank(message = "성별을 기입해주세요")
    private String gender;

    private String address;

}

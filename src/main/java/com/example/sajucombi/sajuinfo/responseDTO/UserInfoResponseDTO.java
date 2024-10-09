package com.example.sajucombi.sajuinfo.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInfoResponseDTO {

    private String code;
    private String msg;
}

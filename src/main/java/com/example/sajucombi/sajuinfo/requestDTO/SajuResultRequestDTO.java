package com.example.sajucombi.sajuinfo.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SajuResultRequestDTO {

    // 사용자를 저장함과 동시에 해당 데이터들을 요청함으로써 API DB에 있는 데이터를 가져온다.
    // 그리고 일주에 데이터를 기입한다.
    private Long solYear;
    private Long solMonth;
    private Long solDay;

}

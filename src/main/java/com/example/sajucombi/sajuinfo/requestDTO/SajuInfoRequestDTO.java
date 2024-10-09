package com.example.sajucombi.sajuinfo.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//사주에 대한 정보 불러오는 DTO 해당 DTO는 궁합에 대한 데이터를 불러오는 DTO이다. -> Response인거 같기도...
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SajuInfoRequestDTO {
    private Long lunIljinId;

    //해당 일주를 토대로 데이터를 요청하는 것이기 때문에 해당 부분만 있으면 된다고 판단.
    private String lunIlJin;
//    private String summary;
//    private String correctType;
//    private String incorrectType;
//    private String cInnerType;
//    private String incInncerType;
//    private String sajuImage;
    private Long sajuId;

}

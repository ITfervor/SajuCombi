package com.example.sajucombi.sajuinfo.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SajuInfoResponseDTO {

    private Long lunIljinId;
    private String lunIljin;
    private String summary;
    private String correctType;
    private String incorrectType;
    private String CInnerType;
    private String IncInnerType;
    private String sajuImage;

}

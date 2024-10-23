package com.example.sajucombi.sajuinfo.requestDTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SajuInfoUpdateRequesetDTO {

    @NotNull(message = "수정 권한이 없습니다.")
    private Long lunIljinId;
    @NotNull(message = "수정 권한이 없습니다.")
    private String lunIljin;
    @NotNull(message = "요약의 수정사항을 입력하세요")
    private String summary;
    @NotNull(message = "겉궁합 수정 사항을 입력하세요")
    private String correctType;
    @NotNull(message = "겉궁합 수정 사항을 입력하세요")
    private String incorrectType;
    @NotNull(message = "속궁합 수정 사항을 입력하세요")
    private String CInnerType;
    @NotNull(message = "속궁합 수정 사항을 입력하세요")
    private String IncInnerType;
    @Nullable
    private String sajuImage;
}

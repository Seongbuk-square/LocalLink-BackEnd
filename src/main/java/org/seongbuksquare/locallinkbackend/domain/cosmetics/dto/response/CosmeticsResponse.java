package org.seongbuksquare.locallinkbackend.domain.cosmetics.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(title = "CosmeticsResponse DTO", description = "화장품 응답 DTO")
public class CosmeticsResponse {

    @Schema(description = "화장품 고유번호", example = "1")
    private Integer cosmeticId;

    @Schema(description = "화장품 순위", example = "1")
    private Integer ranking;

    @Schema(description = "화장품 이름", example = "에센스 크림")
    private String cosmeticName;

    @Schema(description = "화장품 사진 s3 Key", example = "...")
    private String cosmeticImageKey;

    @Schema(description = "화장품 회사 이름", example = "설화수")
    private String companyName;
}

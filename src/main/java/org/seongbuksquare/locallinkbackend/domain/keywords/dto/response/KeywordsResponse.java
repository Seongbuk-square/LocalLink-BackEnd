package org.seongbuksquare.locallinkbackend.domain.keywords.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(title="KeywordsResponse DTO ", description = "급상승 검색어 응답 DTO")
public class KeywordsResponse {

    @Schema(description = "검색어 고유번호", example = "1")
    private Integer keywordId;

    @Schema(description = "급상승 검색어 순위", example = "1")
    private Integer keywordRanking;

    @Schema(description = "급상승 검색어 이름", example = "달팽이 크림")
    private String keywordName;
}

package org.seongbuksquare.locallinkbackend.domain.keywords.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.seongbuksquare.locallinkbackend.domain.keywords.dto.response.KeywordsResponse;
import org.seongbuksquare.locallinkbackend.domain.keywords.service.KeywordsService;
import org.seongbuksquare.locallinkbackend.global.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = "keywords", description = "급상승 검색어 관련 API")
public class KeywordController {

    private final KeywordsService keywordsService;

    @GetMapping("/keywords")
    @Operation(summary = "급상승 검색어 랭킹순 전체 조회", description = "급상승 검색어 랭킹순으로 전체 조회하는 API")
    public ResponseEntity<BaseResponse<List<KeywordsResponse>>> getAllKeywordsByRanking(
            @RequestParam(defaultValue = "ko") String languageCode) {
        List<KeywordsResponse> list = keywordsService.getKeywordsByRanking(languageCode);
        return ResponseEntity.ok(BaseResponse.success("급상승 검색어 랭킹순 전체 조회", list));
    }
}

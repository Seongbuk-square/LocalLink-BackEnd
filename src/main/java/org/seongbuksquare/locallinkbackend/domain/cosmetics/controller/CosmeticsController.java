package org.seongbuksquare.locallinkbackend.domain.cosmetics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.dto.response.CosmeticsResponse;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.service.CosmeticsService;
import org.seongbuksquare.locallinkbackend.global.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "cosmetics", description = "화장품 관련 API")
public class CosmeticsController {
    private final CosmeticsService cosmeticsService;

    // 화장품 랭킹 별 전체 조회 API
    @GetMapping("/cosmetics")
    @Operation(summary = "랭킹 순 화장품 전체 조회", description = "랭킹 순 화장품 전체 조회 API")
    public ResponseEntity<BaseResponse<List<CosmeticsResponse>>> getAllCosmeticsByRanking(@RequestParam(defaultValue = "ko") String languageCode) {
        List<CosmeticsResponse> list = cosmeticsService.getAllCosmeticsByRanking(languageCode);
        return ResponseEntity.ok(BaseResponse.success("랭킹 순 화장품 전체 조회",list));
    }
}

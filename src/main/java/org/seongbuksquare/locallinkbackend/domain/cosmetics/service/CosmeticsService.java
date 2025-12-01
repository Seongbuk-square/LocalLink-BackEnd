package org.seongbuksquare.locallinkbackend.domain.cosmetics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.dto.response.CosmeticsResponse;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.entity.Cosmetics;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.entity.CosmeticsTrans;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.exception.CosmeticsErrorCode;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.repository.CosmeticsRepository;
import org.seongbuksquare.locallinkbackend.global.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CosmeticsService {

    private final CosmeticsRepository cosmeticsRepository;

    // 화장품 랭킹 별 전체 조회 (1위~10위)
    public List<CosmeticsResponse> getAllCosmeticsByRanking(String languageCode) {

        log.info("[CosmeticsService] 랭킹 순 화장품 전체 조회 시도");

        List<Cosmetics> cosmeticsList = cosmeticsRepository.findAllByOrderByRankingAsc();

        if (cosmeticsList.isEmpty()) {
            throw new CustomException(CosmeticsErrorCode.COSMETICS_NOT_FOUND); // 등록된 화장품 없을 때
        }

        List<CosmeticsResponse> responseList = cosmeticsList.stream()
                .map(cosmetic -> {
                    // 언어 번역 선택, 없으면 기본 언어 ko
                    CosmeticsTrans trans = cosmetic.getCosmeticsTransList().stream()
                            .filter(t -> t.getLanguageCode().equals(languageCode))
                            .findFirst()
                            .or(() -> cosmetic.getCosmeticsTransList().stream()
                                    .filter(t -> t.getLanguageCode().equals("ko"))
                                    .findFirst()
                            )
                            .orElseThrow(() -> new CustomException(CosmeticsErrorCode.COSMETICS_NOT_FOUND));

                    return CosmeticsResponse.builder()
                            .cosmeticId(cosmetic.getCosmeticId())
                            .ranking(cosmetic.getRanking())
                            .cosmeticImageKey(cosmetic.getCosmeticImageKey())
                            .cosmeticName(trans.getCosmeticName())
                            .companyName(trans.getCompanyName())
                            .build();
                })
                .toList();

        log.info("[CosmeticsService] 랭킹 순 화장품 전체 조회 성공");
        return responseList;
    }
}
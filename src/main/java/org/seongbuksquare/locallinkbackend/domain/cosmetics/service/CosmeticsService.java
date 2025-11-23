package org.seongbuksquare.locallinkbackend.domain.cosmetics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.dto.response.CosmeticsResponse;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.entity.Cosmetics;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.entity.CosmeticsTrans;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.repository.CosmeticsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return cosmeticsList.stream()
                .map(cosmetic -> {
                    // 해당 cosmetic의 언어 번역 선택
                    CosmeticsTrans trans = cosmetic.getCosmeticsTransList().stream()
                            .filter(t -> t.getLanguageCode().equals(languageCode))
                            .findFirst()
                            .orElse(null);

                    // 혹시 해당 언어 번역이 없으면 기본 언어(예: ko)로 fallback
                    if (trans == null) {
                        trans = cosmetic.getCosmeticsTransList().stream()
                                .filter(t -> t.getLanguageCode().equals("ko"))
                                .findFirst()
                                .orElse(null);
                    }

                    log.info("[CosmeticsService] 랭킹 순 화장품 전체 조회 성공");

                    return CosmeticsResponse.builder()
                            .cosmeticId(cosmetic.getCosmeticId())
                            .ranking(cosmetic.getRanking())
                            .cosmeticImageKey(cosmetic.getCosmeticImageKey())
                            .cosmeticName(trans != null ? trans.getCosmeticName() : null)
                            .companyName(trans != null ? trans.getCompanyName() : null)
                            .build();
                })
                .toList();

    }
}

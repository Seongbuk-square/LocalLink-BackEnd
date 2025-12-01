package org.seongbuksquare.locallinkbackend.domain.keywords.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seongbuksquare.locallinkbackend.domain.keywords.dto.response.KeywordsResponse;
import org.seongbuksquare.locallinkbackend.domain.keywords.entity.Keywords;
import org.seongbuksquare.locallinkbackend.domain.keywords.entity.KeywordsTrans;
import org.seongbuksquare.locallinkbackend.domain.keywords.exception.KeywordsErrorCode;
import org.seongbuksquare.locallinkbackend.domain.keywords.repository.KeywordsRepository;
import org.seongbuksquare.locallinkbackend.global.exception.CustomException;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KeywordsService {
    private final KeywordsRepository keywordsRepository;

    // 급상승 검색어 인기순 전체 조회
    public List<KeywordsResponse> getKeywordsByRanking(String languageCode) {

        log.info("[KeywordsService] 급상승 검색어 랭킹 순 전체 조회 시도");

        List<Keywords> keywordsList = keywordsRepository.findAllByOrderByKeywordRankingAsc();

        if(keywordsList.isEmpty()) {
            throw new CustomException(KeywordsErrorCode.KEYWORDS_NOT_FOUND);
        }
        List<KeywordsResponse> keywordsResponseList = keywordsList.stream()
                .map(keywords -> {
                    KeywordsTrans trans = keywords.getKeywordsTransList().stream()
                            .filter(t -> t.getLanguageCode().equals(languageCode))
                            .findFirst()
                            .or(() -> keywords.getKeywordsTransList().stream()
                                    .filter(t -> t.getLanguageCode().equals("ko"))
                                    .findFirst()
                            ).orElseThrow(() -> new CustomException(KeywordsErrorCode.KEYWORDS_NOT_FOUND));
                    return toKeywordsResponse(keywords, trans);
                }).toList();
        log.info("[KeywordsService] 급상승 검색어 인기순 전체 조회 성공");
        return keywordsResponseList;
    }

    public KeywordsResponse toKeywordsResponse(Keywords keywords, KeywordsTrans keywordsTrans) {
        return KeywordsResponse.builder()
                .keywordId(keywords.getKeywordId())
                .keywordRanking(keywords.getKeywordRanking())
                .keywordName(keywordsTrans.getKeywordName())
                .build();
    }
}

package org.seongbuksquare.locallinkbackend.domain.keywords.repository;

import java.util.List;
import org.seongbuksquare.locallinkbackend.domain.keywords.entity.Keywords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordsRepository extends JpaRepository<Keywords, Integer> {

    // 급상승 검색어 랭킹 순 전체 조회
    List<Keywords> findAllByOrderByKeywordRankingAsc();
}

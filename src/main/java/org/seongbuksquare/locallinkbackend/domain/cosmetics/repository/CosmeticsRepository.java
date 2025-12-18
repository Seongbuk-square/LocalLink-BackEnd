package org.seongbuksquare.locallinkbackend.domain.cosmetics.repository;

import java.util.List;
import org.seongbuksquare.locallinkbackend.domain.cosmetics.entity.Cosmetics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CosmeticsRepository extends JpaRepository<Cosmetics, Integer> {

    // 랭킹 오름차순 별 화장품 전체 조회
    List<Cosmetics> findAllByOrderByRankingAsc();
}

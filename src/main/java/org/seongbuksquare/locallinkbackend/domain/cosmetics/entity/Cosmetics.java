package org.seongbuksquare.locallinkbackend.domain.cosmetics.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "cosmetics",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ranking"}) // 테이블 레벨에서 명시적으로 유니크 제약 추가
        })
public class Cosmetics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cosmeticId;

    @Column(nullable = false, unique = true) // ✅ ranking은 고유해야 함
    private Integer ranking;

    @Column(nullable = false)
    private String cosmeticImageKey;

    @OneToMany(mappedBy = "cosmetics", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CosmeticsTrans> cosmeticsTransList = new ArrayList<>();

    public void addTranslation(CosmeticsTrans cosmeticsTrans) {
        cosmeticsTransList.add(cosmeticsTrans);
        cosmeticsTrans.setCosmetics(this);
    }
}

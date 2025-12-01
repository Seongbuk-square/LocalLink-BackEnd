package org.seongbuksquare.locallinkbackend.domain.cosmetics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cosmetics")
public class Cosmetics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cosmeticId;

    @Column(nullable = false)
    private Integer ranking;

    @Column(nullable = false)
    private String cosmeticImageKey;

    // 1:N
    @OneToMany(mappedBy = "cosmetics", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CosmeticsTrans> cosmeticsTransList = new ArrayList<>();

    // 편의 메서드 (양방향 연결)
    public void addTranslation(CosmeticsTrans cosmeticsTrans) { // 번역이 추가됐을때
        cosmeticsTransList.add(cosmeticsTrans); // Cosmetics에서 인식할 수 있게 cosmeticsTrans 객체 추가
        cosmeticsTrans.setCosmetics(this); // cosmeticsTrans 객체의 cosmetic 필드도 이 cosmetic 객체로 수정
    }
}

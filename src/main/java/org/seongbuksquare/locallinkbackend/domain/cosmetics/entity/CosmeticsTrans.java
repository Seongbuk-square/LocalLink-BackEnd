package org.seongbuksquare.locallinkbackend.domain.cosmetics.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "cosmetics_trans",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "uk_cosmetic_language",
                    columnNames = {"cosmetic_id", "languageCode"} // 엔티티 필드명 혹은 DB 컬럼명 확인
                    )
        })
public class CosmeticsTrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cosmeticsTransId;

    @Column(nullable = false)
    private String languageCode;

    @Column(nullable = false)
    private String cosmeticName;

    @Column(nullable = false)
    private String companyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cosmetic_id", nullable = false)
    private Cosmetics cosmetics;
}

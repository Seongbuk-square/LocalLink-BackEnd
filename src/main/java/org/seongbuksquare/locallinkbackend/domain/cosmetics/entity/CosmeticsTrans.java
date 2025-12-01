package org.seongbuksquare.locallinkbackend.domain.cosmetics.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

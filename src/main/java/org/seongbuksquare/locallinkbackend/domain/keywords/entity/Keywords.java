package org.seongbuksquare.locallinkbackend.domain.keywords.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "keywords",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"keywordRanking"})})
public class Keywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer keywordId;

    @Column(nullable = false, unique = true) // ✅ 유니크 추가
    private Integer keywordRanking;

    @OneToMany(mappedBy = "keywords", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default // Builder 사용 시 리스트 초기화 보장
    private List<KeywordsTrans> keywordsTransList = new ArrayList<>();
}

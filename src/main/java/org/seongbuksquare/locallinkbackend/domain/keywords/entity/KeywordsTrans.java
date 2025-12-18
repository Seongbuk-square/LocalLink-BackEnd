package org.seongbuksquare.locallinkbackend.domain.keywords.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "keywords_trans",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "uk_keyword_language",
                    columnNames = {"keyword_id", "languageCode"})
        })
public class KeywordsTrans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer keywordsTransId;

    @Column(nullable = false)
    private String languageCode;

    @Column(nullable = false)
    private String keywordName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keywords keywords;
}

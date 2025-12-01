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
@Table(name="keywords_trans")
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

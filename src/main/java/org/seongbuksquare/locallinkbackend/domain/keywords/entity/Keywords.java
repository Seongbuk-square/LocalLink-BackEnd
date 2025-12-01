package org.seongbuksquare.locallinkbackend.domain.keywords.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="keywords")
public class Keywords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer keywordId;

    @Column(nullable=false)
    private Integer keywordRanking;

    // 1:N
    @OneToMany(mappedBy = "keywords", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KeywordsTrans> keywordsTransList = new ArrayList<>();
}

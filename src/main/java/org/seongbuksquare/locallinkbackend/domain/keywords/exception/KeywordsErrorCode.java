package org.seongbuksquare.locallinkbackend.domain.keywords.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.seongbuksquare.locallinkbackend.global.exception.model.BaseErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum KeywordsErrorCode implements BaseErrorCode {
    KEYWORDS_NOT_FOUND("KEYWORDS_4001", "해당 인기 검색어를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;
}

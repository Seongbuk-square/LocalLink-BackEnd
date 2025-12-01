package org.seongbuksquare.locallinkbackend.domain.cosmetics.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import okhttp3.internal.http2.ErrorCode;
import org.seongbuksquare.locallinkbackend.global.exception.model.BaseErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CosmeticsErrorCode implements BaseErrorCode {

    COSMETICS_NOT_FOUND("COSMETICS_4001", "화장품을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String message;
    private final HttpStatus status;
}

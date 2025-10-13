package org.seongbuksquare.locallinkbackend.global.exception;


import lombok.Getter;
import org.seongbuksquare.locallinkbackend.global.exception.model.BaseErrorCode;

@Getter
public class CustomException extends RuntimeException {
    private final BaseErrorCode errorCode;

    public CustomException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

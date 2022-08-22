package com.crawling.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MemberCreateErrorException extends RuntimeException {

    private final Throwable cause;

    public MemberCreateErrorException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return "-- 사용자 생성 실패 --\n" + cause.getMessage();
    }
}

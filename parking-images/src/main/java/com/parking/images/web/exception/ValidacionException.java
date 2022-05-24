package com.parking.images.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ValidacionException extends DevelopUserException {

    @Getter
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public ValidacionException(String developMessage, String userMessage) {
        super(developMessage, userMessage);
    }

    public ValidacionException(String developMessage, String userMessage, Throwable cause) {
        super(developMessage, userMessage, cause);
    }

}

package com.parking.images.web.exception;

import org.springframework.http.HttpStatus;

public class ElementoNoEncontradoException extends DevelopUserException {

    public ElementoNoEncontradoException(String developMessage, String userMessage) {
        super(developMessage, userMessage);
    }

    public ElementoNoEncontradoException(String developMessage, String userMessage, Throwable cause) {
        super(developMessage, userMessage, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

package com.parking.images.web.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public abstract class DevelopUserException extends Exception {
    @Setter @Getter
    private String developMessage;
    @Setter @Getter
    private String userMessage;

    public DevelopUserException(String developMessage, String userMessage) {
        super(developMessage);
        this.developMessage = developMessage;
        this.userMessage = userMessage;
    }

    public DevelopUserException(String developMessage, String userMessage, Throwable cause) {
        super(developMessage, cause);
        this.developMessage = developMessage;
        this.userMessage = userMessage;
    }

    abstract public HttpStatus getStatus();
}

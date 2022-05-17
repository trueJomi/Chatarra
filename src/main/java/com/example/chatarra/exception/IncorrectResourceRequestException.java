package com.example.chatarra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectResourceRequestException extends RuntimeException {

    public IncorrectResourceRequestException() {
        super();
    }

    public IncorrectResourceRequestException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IncorrectResourceRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectResourceRequestException(String message) {
        super(message);
    }

    public IncorrectResourceRequestException(Throwable cause) {
        super(cause);
    }
}
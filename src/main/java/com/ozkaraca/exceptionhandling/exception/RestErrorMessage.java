package com.ozkaraca.exceptionhandling.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestErrorMessage {

    private int httpStatusCode;
    private int code;
    private String message;
    private String exception;

    public RestErrorMessage(HttpStatus status, int code, String message,
                            String exception) {
        this.httpStatusCode = status.value();
        this.code = code;
        this.message = message;
        this.exception = exception;
    }

}

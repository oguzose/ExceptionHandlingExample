package com.ozkaraca.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FlightCountException extends BaseException {

    private static final long serialVersionUID = 1L;

    public FlightCountException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}

package com.ozkaraca.exceptionhandling.exception;

import org.springframework.http.HttpStatus;

public class NoDataFoundException extends BaseException {

    public NoDataFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), "No data found " + message);
    }
}

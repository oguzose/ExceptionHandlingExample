package com.ozkaraca.exceptionhandling.exception;

public abstract class BaseException extends RuntimeException {

    private String message;

    private int code;

    public BaseException(int code, String message) {
        this(code);
        this.message = message;
    }

    public BaseException(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}

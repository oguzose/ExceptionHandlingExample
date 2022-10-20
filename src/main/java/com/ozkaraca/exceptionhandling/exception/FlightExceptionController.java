package com.ozkaraca.exceptionhandling.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FlightExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInvalidRequest(Exception ex, ServletWebRequest request) {

        int httpCode = 0;
        String exceptionMessage = null;
        HttpStatus httpStatus = null;

        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            exceptionMessage = baseException.getMessage();
            httpCode = baseException.getCode();
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            exceptionMessage = "An internal error";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestErrorMessage error = new RestErrorMessage(httpStatus, httpCode, exceptionMessage, ex.toString());
        return handleExceptionInternal(ex, error, headers, httpStatus, request);
    }

}
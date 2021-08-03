package com.gaspar.cobrancanotificaemail.config;

import com.gaspar.cobrancanotificaemail.exception.DuplicatedRecordException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    public Map<String, Object> getBody(HttpStatus status, Exception ex, String message) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("status", status.value());
        body.put("timestamp", new Date());
        body.put("error", status.getReasonPhrase());
        body.put("exception", ex.toString());

        Throwable cause = ex.getCause();
        if (cause != null) {
            body.put("exceptionCause", ex.getCause().toString());
        }
        return body;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
        return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, ex, "Wrong number format"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(getBody(HttpStatus.CONFLICT, ex, ex.getMessage()), new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicatedRecordException.class)
    public ResponseEntity<Object> handleDuplicatedRecordException(DuplicatedRecordException ex) {
        return new ResponseEntity<>(getBody(HttpStatus.CONFLICT, ex, ex.getMessage()), new HttpHeaders(), HttpStatus.CONFLICT);
    }
}

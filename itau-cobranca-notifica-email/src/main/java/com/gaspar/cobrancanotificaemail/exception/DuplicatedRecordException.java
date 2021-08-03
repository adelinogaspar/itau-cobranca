package com.gaspar.cobrancanotificaemail.exception;

public class DuplicatedRecordException extends RuntimeException {
    private static final long serialVersionUID = 15469766465497L;

    public DuplicatedRecordException(String errorMessage) {
        super(errorMessage);
    }

    public DuplicatedRecordException() {
        this("Registro duplicado");
    }
}

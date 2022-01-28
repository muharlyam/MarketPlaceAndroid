package com.muharlyam.domain.model.wrappers;

public class GeneralResult {

    private Throwable exception;

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public boolean isSuccessful() {
        return exception == null;
    }
}

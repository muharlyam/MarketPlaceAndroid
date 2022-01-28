package com.muharlyam.domain.model.wrappers;

public class Result<T> extends GeneralResult {

    private T result;

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}

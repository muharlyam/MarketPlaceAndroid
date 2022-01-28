package com.muharlyam.domain.model.wrappers;

public class NetworkResult<T> extends Result<T> {

    private int httpCode;

    public void setNetworkException(int errorCode) {
        setException(new Exception("Network exception: " + errorCode));
        httpCode = errorCode;
    }

}

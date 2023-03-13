package com.tosan.customer_sample.core.exception;

public class AccountIdNullException extends Exception {

    private int errorCode;

    public AccountIdNullException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}

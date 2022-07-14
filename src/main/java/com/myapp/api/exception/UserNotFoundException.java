package com.myapp.api.exception;

public class UserNotFoundException  extends Exception{
    private final String errorCode;
    private final String errorMessage;

    public UserNotFoundException(final String errorCode) {
        super(ErrorResourceBundle.getMessage(errorCode));
        this.errorCode = errorCode;
        this.errorMessage = ErrorResourceBundle.getMessage(errorCode);
    }

    public UserNotFoundException(final String errorCode, final Object... data) {
        super(ErrorResourceBundle.getMessage(errorCode, data));
        this.errorCode = errorCode;
        this.errorMessage = ErrorResourceBundle.getMessage(errorCode, data);
    }
}

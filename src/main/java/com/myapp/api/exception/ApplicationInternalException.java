package com.myapp.api.exception;

public class ApplicationInternalException extends Exception{
    private final String errorCode;
    private final String errorMessage;

    public ApplicationInternalException(final String errorCode) {
        super(ErrorResourceBundle.getMessage(errorCode));
        this.errorCode = errorCode;
        this.errorMessage = ErrorResourceBundle.getMessage(errorCode);
    }

    public ApplicationInternalException(final String errorCode, final Object... data) {
        super(ErrorResourceBundle.getMessage(errorCode, data));
        this.errorCode = errorCode;
        this.errorMessage = ErrorResourceBundle.getMessage(errorCode, data);
    }
}

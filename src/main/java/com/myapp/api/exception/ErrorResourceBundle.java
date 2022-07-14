package com.myapp.api.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ErrorResourceBundle {
    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("error.application_error");

  private ErrorResourceBundle() {
        super();
    }
        public static String getMessage(final String key) {
        return BUNDLE.getString(key);
    }

    public static String getMessage(final String key, Object ...objects ) {
        String message = BUNDLE.getString(key);
        return MessageFormat.format(message, objects);
    }
}

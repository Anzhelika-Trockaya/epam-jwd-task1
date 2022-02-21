package com.epam.jwd.task1.exception;

public class CustomArrayParseException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 3598624292400228114L;

    public CustomArrayParseException() {
        super();
    }

    public CustomArrayParseException(String message) {
        super(message);
    }

    public CustomArrayParseException(Exception exception) {
        super(exception);
    }

    public CustomArrayParseException(String message, Exception exception) {
        super(message, exception);
    }
}


package com.epam.jwd.task1.exception;

public class CustomArrayReaderException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -7671484734656481409L;

    public CustomArrayReaderException() {
        super();
    }

    public CustomArrayReaderException(String message) {
        super(message);
    }

    public CustomArrayReaderException(Exception exception) {
        super(exception);
    }

    public CustomArrayReaderException(String message, Exception exception) {
        super(message, exception);
    }
}


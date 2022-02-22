package com.epam.task1.exception;

public class CustomArrayException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -4402803431514480305L;

    public CustomArrayException() {
        super();
    }

    public CustomArrayException(String message) {
        super(message);
    }

    public CustomArrayException(Exception exception) {
        super(exception);
    }

    public CustomArrayException(String message, Exception exception) {
        super(message, exception);
    }
}


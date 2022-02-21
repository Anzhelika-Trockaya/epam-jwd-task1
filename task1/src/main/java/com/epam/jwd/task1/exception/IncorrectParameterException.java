package com.epam.jwd.task1.exception;

public class IncorrectParameterException extends ServiceException {
    /**
     *
     */
    private static final long serialVersionUID = -4481404040411947280L;

    public IncorrectParameterException() {
        super();
    }

    public IncorrectParameterException(String message) {
        super(message);
    }

    public IncorrectParameterException(Exception exception) {
        super(exception);
    }

    public IncorrectParameterException(String message, Exception exception) {
        super(message, exception);
    }
}


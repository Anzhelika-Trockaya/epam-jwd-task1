package com.epam.jwd.task1.exception;

public class ServiceException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -4402803431514480305L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception exception) {
        super(exception);
    }

    public ServiceException(String message, Exception exception) {
        super(message, exception);
    }
}


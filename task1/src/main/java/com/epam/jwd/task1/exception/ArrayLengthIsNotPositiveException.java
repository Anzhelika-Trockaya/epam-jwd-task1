package com.epam.jwd.task1.exception;

public class ArrayLengthIsNotPositiveException extends ServiceException {
    /**
     *
     */
    private static final long serialVersionUID = -4701513169906473884L;

    public ArrayLengthIsNotPositiveException() {
        super();
    }

    public ArrayLengthIsNotPositiveException(String message) {
        super(message);
    }

    public ArrayLengthIsNotPositiveException(Exception exception) {
        super(exception);
    }

    public ArrayLengthIsNotPositiveException(String message, Exception exception) {
        super(message, exception);
    }
}

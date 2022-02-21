package com.epam.jwd.task1.exception;

public class NullArrayException extends ServiceException {
    /**
     *
     */
    private static final long serialVersionUID = -2574573228850775655L;

    public NullArrayException() {
        super();
    }

    public NullArrayException(String message) {
        super(message);
    }

    public NullArrayException(Exception exception) {
        super(exception);
    }

    public NullArrayException(String message, Exception exception) {
        super(message, exception);
    }
}


package com.epam.jwd.task1.exception;

public class CustomArrayLineValidatorException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 4760707821559349575L;

    public CustomArrayLineValidatorException() {
        super();
    }

    public CustomArrayLineValidatorException(String message) {
        super(message);
    }

    public CustomArrayLineValidatorException(Exception exception) {
        super(exception);
    }

    public CustomArrayLineValidatorException(String message, Exception exception) {
        super(message, exception);
    }
}


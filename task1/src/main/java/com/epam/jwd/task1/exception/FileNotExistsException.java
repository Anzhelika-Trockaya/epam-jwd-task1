package com.epam.jwd.task1.exception;

public class FileNotExistsException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -2892852562297030645L;

    public FileNotExistsException() {
        super();
    }

    public FileNotExistsException(String message) {
        super(message);
    }

    public FileNotExistsException(Exception exception) {
        super(exception);
    }

    public FileNotExistsException(String message, Exception exception) {
        super(message, exception);
    }
}


package com.epam.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayLineValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ArrayLineValidator instance = new ArrayLineValidator();
    private static final String ARRAY_REGEX = "\\s*-?\\d+(\\s*;\\s*-?\\d+)*\\s*";

    private ArrayLineValidator(){
    }

    public static ArrayLineValidator getInstance(){
        return instance;
    }

    public boolean isArrayLineCorrect(String line) {
        LOGGER.info("is array line correct");
        return line != null && (line.isBlank() || line.matches(ARRAY_REGEX));
    }
}


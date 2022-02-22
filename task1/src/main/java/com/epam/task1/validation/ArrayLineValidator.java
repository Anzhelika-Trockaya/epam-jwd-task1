package com.epam.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayLineValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ARRAY_REGEX = "\\s*-?\\d+(\\s*;\\s*-?\\d+)*\\s*";

    public boolean isArrayLineCorrect(String line) {
        LOGGER.info("is array line correct");
        return line != null && (line.isBlank() || line.matches(ARRAY_REGEX));
    }
}


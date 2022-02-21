package com.epam.jwd.task1.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.exception.CustomArrayLineValidatorException;

public class CustomArrayLineValidator {
    private static final Logger LOGGER = LogManager.getLogger(CustomArrayLineValidator.class.getName());
    private final String customArrayRegex;

    public CustomArrayLineValidator() {
        LOGGER.info("creating new CustomArrayLineValidator()");
        customArrayRegex = "\\s*-?\\d+(\\s*;\\s*-?\\d+)*\\s*";
    }

    public CustomArrayLineValidator(String splitterRegex) throws CustomArrayLineValidatorException {
        LOGGER.info("creating new CustomArrayLineValidator(" + splitterRegex + ")");
        if (splitterRegex.matches("\\s*-") || splitterRegex.matches("[0-9]")) {
            throw new CustomArrayLineValidatorException("Incorrect splitterRegex: '" + splitterRegex + "'");
        }
        customArrayRegex = "\\s*-?\\d+(" + splitterRegex + "-?\\d+)*\\s*";
    }

    public boolean isCustomArrayLineCorrect(String line) {
        LOGGER.info("is CustomArray line correct");
        return line != null && (line.isEmpty() || line.matches(customArrayRegex));
    }
}


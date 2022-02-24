package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayChecker {
    private static final Logger LOGGER = LogManager.getLogger();

    public void checkArray(CustomArray array) throws CustomArrayException {
        LOGGER.debug("Check CustomArray");
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length < 0) {
            LOGGER.warn("CustomArrays elements length is less than zero");
            throw new CustomArrayException("CustomArrays elements length is less than zero");
        }
    }
}


package com.epam.jwd.task1.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ArrayLengthIsNotPositiveException;
import com.epam.jwd.task1.exception.NullArrayException;
import com.epam.jwd.task1.exception.ServiceException;

public class ArrayChecker {
    private static final Logger LOGGER = LogManager.getLogger(ArrayChecker.class.getName());

    public void checkArray(CustomArray array) throws ServiceException {
        LOGGER.info("Check CustomArray");
        if (array == null || array.getElements() == null) {
            throw new NullArrayException();
        }
        int[] elements = array.getElements();
        if (elements.length <= 0) {
            throw new ArrayLengthIsNotPositiveException();
        }
    }
}


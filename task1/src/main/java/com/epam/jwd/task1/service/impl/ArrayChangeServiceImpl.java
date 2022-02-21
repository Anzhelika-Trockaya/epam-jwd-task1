package com.epam.jwd.task1.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.IncorrectParameterException;
import com.epam.jwd.task1.exception.ServiceException;

import com.epam.jwd.task1.service.ArrayChangeService;

public class ArrayChangeServiceImpl implements ArrayChangeService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayChangeServiceImpl.class.getName());

    @Override
    public void replaceAll(CustomArray array, int value, int replacement) throws ServiceException {
        LOGGER.info("Replace all elements equals value");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllGreaterThanValue(CustomArray array, int value, int replacement) throws ServiceException {
        LOGGER.info("Replace all elements greater than value");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllLessThanValue(CustomArray array, int value, int replacement) throws ServiceException {
        LOGGER.info("Replace all elements less than value");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllNegative(CustomArray array, int value) throws ServiceException {
        LOGGER.info("Replace all negative elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                elements[i] = value;
            }
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllInInterval(CustomArray array, int startIndex, int intervalLength, int value)
            throws ServiceException {
        LOGGER.info("Replace all elements in interval");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int endIndex = startIndex + intervalLength - 1;
        if (startIndex < 0 || intervalLength < 0 || elements.length < endIndex + 1) {
            throw new IncorrectParameterException();
        }
        for (int i = startIndex; i < endIndex; i++) {
            elements[i] = value;
        }
        array.setElements(elements);
    }
}


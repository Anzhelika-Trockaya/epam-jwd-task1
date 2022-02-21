package com.epam.jwd.task1.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

import com.epam.jwd.task1.service.ArrayFoundService;

public class ArrayFoundServiceImpl implements ArrayFoundService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFoundServiceImpl.class.getName());

    @Override
    public int foundMax(CustomArray array) throws ServiceException {
        LOGGER.info("found max element");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int currentMax = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > currentMax) {
                currentMax = elements[i];
            }
        }
        return currentMax;
    }

    @Override
    public int foundMin(CustomArray array) throws ServiceException {
        LOGGER.info("found min element");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int currentMin = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < currentMin) {
                currentMin = elements[i];
            }
        }
        return currentMin;
    }

    @Override
    public long foundSumOfElements(CustomArray array) throws ServiceException {
        LOGGER.info("found sum of elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        long sum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            sum += (long) elements[i];
        }
        return sum;
    }

    @Override
    public int foundNumberOfPositive(CustomArray array) throws ServiceException {
        LOGGER.info("found number of positive elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int numberOfPositive = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > 0) {
                numberOfPositive++;
            }
        }
        return numberOfPositive;
    }

    @Override
    public int foundNumberOfNegative(CustomArray array) throws ServiceException {
        LOGGER.info("found number of negative elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int numberOfNegative = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                numberOfNegative++;
            }
        }
        return numberOfNegative;
    }

}

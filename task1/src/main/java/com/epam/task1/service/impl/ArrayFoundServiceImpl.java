package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task1.service.ArrayFoundService;

import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArrayFoundServiceImpl implements ArrayFoundService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFoundServiceImpl.class.getName());

    @Override
    public OptionalInt foundMax(CustomArray array) throws CustomArrayException {
        LOGGER.info("found max element");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return OptionalInt.empty();
        }
        int currentMax = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > currentMax) {
                currentMax = elements[i];
            }
        }
        return OptionalInt.of(currentMax);
    }

    @Override
    public OptionalInt foundMin(CustomArray array) throws CustomArrayException {
        LOGGER.info("found min element");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return OptionalInt.empty();
        }
        int currentMin = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < currentMin) {
                currentMin = elements[i];
            }
        }
        return OptionalInt.of(currentMin);
    }

    @Override
    public OptionalLong foundSumOfElements(CustomArray array) throws CustomArrayException {
        LOGGER.info("found sum of elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return OptionalLong.empty();
        }
        long sum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            sum += elements[i];
        }
        return OptionalLong.of(sum);
    }

    @Override
    public int foundNumberOfPositive(CustomArray array) throws CustomArrayException {
        LOGGER.info("found number of positive elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int numberOfPositive = 0;
        for (int element : elements) {
            if (element > 0) {
                numberOfPositive++;
            }
        }
        return numberOfPositive;
    }

    @Override
    public int foundNumberOfNegative(CustomArray array) throws CustomArrayException {
        LOGGER.info("found number of negative elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int numberOfNegative = 0;
        for (int element : elements) {
            if (element < 0) {
                numberOfNegative++;
            }
        }
        return numberOfNegative;
    }

}

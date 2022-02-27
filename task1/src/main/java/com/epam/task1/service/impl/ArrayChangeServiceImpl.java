package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayChangeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayChangeServiceImpl implements ArrayChangeService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void replaceAll(CustomArray array, int value, int replacement) throws CustomArrayException {
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
    public void replaceAllGreaterThanValue(CustomArray array, int value, int replacement) throws CustomArrayException {
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
    public void replaceAllLessThanValue(CustomArray array, int value, int replacement) throws CustomArrayException {
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
    public void replaceAllNegative(CustomArray array, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all negative elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllInInterval(CustomArray array, int startIndex, int intervalLength, int replacement)
            throws CustomArrayException {
        LOGGER.info("Replace all elements in interval");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int endIndex = startIndex + intervalLength - 1;
        if (startIndex < 0 || intervalLength < 0 || elements.length < endIndex + 1) {
            LOGGER.error("Incorrect method params");
            throw new CustomArrayException("Incorrect method params: startIndex=" + startIndex +
                    ", intervalLength=" + intervalLength);
        }
        for (int i = startIndex; i <= endIndex; i++) {
            elements[i] = replacement;
        }
        array.setElements(elements);
    }

    @Override
    public void replaceAllStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all elements equals value using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x == value) ? replacement : x).toArray();
        array.setElements(newElements);
    }

    @Override
    public void replaceAllGreaterThanValueStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all elements greater than value using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x > value) ? replacement : x).toArray();
        array.setElements(newElements);
    }

    @Override
    public void replaceAllLessThanValueStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all elements less than value using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x < value) ? replacement : x).toArray();
        array.setElements(newElements);
    }

    @Override
    public void replaceAllNegativeStream(CustomArray array, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all negative elements using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x < 0) ? replacement : x).toArray();
        array.setElements(newElements);
    }

    @Override
    public void replaceAllInIntervalStream(CustomArray array, int startIndex, int intervalLength, int replacement) throws CustomArrayException {//fixme
        LOGGER.info("Replace all elements in interval using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int endIndex = startIndex + intervalLength - 1;
        if (startIndex < 0 || intervalLength < 0 || elements.length < endIndex + 1) {
            LOGGER.error("Incorrect method params");
            throw new CustomArrayException("Incorrect method params: startIndex=" + startIndex +
                    ", intervalLength=" + intervalLength);
        }
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
       // int[] newElements = ;
        //array.setElements(newElements);
    }
}


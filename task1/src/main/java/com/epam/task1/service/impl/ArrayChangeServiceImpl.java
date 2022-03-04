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
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
        LOGGER.info("All elements equal " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllGreaterThanValue(CustomArray array, int value, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
        LOGGER.info("All elements greater than " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllLessThanValue(CustomArray array, int value, int replacement) throws CustomArrayException {
        LOGGER.info("Replace all elements less than value");
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < value) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
        LOGGER.info("All elements less than " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllNegative(CustomArray array, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                elements[i] = replacement;
            }
        }
        array.setElements(elements);
        LOGGER.info("All negative elements replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x == value) ? replacement : x).toArray();
        array.setElements(newElements);
        LOGGER.info("All elements equal " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllGreaterThanValueStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x > value) ? replacement : x).toArray();
        array.setElements(newElements);
        LOGGER.info("All elements greater than " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllLessThanValueStream(CustomArray array, int value, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x < value) ? replacement : x).toArray();
        array.setElements(newElements);
        LOGGER.info("All elements less than " + value + " replaced to " + replacement + ". " + array);
    }

    @Override
    public void replaceAllNegativeStream(CustomArray array, int replacement) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return;
        }
        IntStream stream = Arrays.stream(elements);
        int[] newElements = stream.map((x) -> (x < 0) ? replacement : x).toArray();
        array.setElements(newElements);
        LOGGER.info("All negative elements replaced to " + replacement + ". " + array);
    }
}


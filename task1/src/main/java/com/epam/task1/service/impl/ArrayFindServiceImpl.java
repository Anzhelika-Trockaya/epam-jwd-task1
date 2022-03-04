package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayFindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayFindServiceImpl implements ArrayFindService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFindServiceImpl.class.getName());

    @Override
    public OptionalInt findMax(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            LOGGER.info("Max not found. " + array);
            return OptionalInt.empty();
        }
        int currentMax = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > currentMax) {
                currentMax = elements[i];
            }
        }
        LOGGER.info("Max = " + currentMax + ". " + array);
        return OptionalInt.of(currentMax);
    }

    @Override
    public OptionalInt findMin(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            LOGGER.info("Min not found. " + array);
            return OptionalInt.empty();
        }
        int currentMin = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < currentMin) {
                currentMin = elements[i];
            }
        }
        LOGGER.info("Min = " + currentMin + ". " + array);
        return OptionalInt.of(currentMin);
    }

    @Override
    public int findSum(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int sum = 0;
        if (elements.length == 0) {
            LOGGER.info("Sum = " + sum + ". " + array);
            return sum;
        }
        sum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if ((elements[i] > 0) ? Integer.MAX_VALUE - elements[i] > sum : Integer.MIN_VALUE - elements[i] < sum) {
                sum += elements[i];
            } else {
                LOGGER.error("sum value is bigger than Integer.MAX_VALUE");
                throw new CustomArrayException("sum value is bigger than Integer.MAX_VALUE");
            }
        }
        LOGGER.info("Sum = " + sum + ". " + array);
        return sum;
    }

    @Override
    public OptionalDouble findAverage(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            LOGGER.info("Average not found. " + array);
            return OptionalDouble.empty();
        }
        int sumOfElements = findSum(array);
        double average = (double) sumOfElements / elements.length;
        LOGGER.info("Average = " + average + ". " + array);
        return OptionalDouble.of(average);
    }

    @Override
    public int findNumberOfPositive(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int numberOfPositive = 0;
        for (int element : elements) {
            if (element > 0) {
                numberOfPositive++;
            }
        }
        LOGGER.info("Number of positive = " + numberOfPositive + ". " + array);
        return numberOfPositive;
    }

    @Override
    public int findNumberOfNegative(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int numberOfNegative = 0;
        for (int element : elements) {
            if (element < 0) {
                numberOfNegative++;
            }
        }
        LOGGER.info("Number of negative = " + numberOfNegative + ". " + array);
        return numberOfNegative;
    }

    @Override
    public OptionalInt findMaxStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        OptionalInt max = Arrays.stream(elements).max();
        LOGGER.info("Max = " + max + ". " + array);
        return max;
    }

    @Override
    public OptionalInt findMinStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        OptionalInt min = Arrays.stream(elements).min();
        LOGGER.info("Min = " + min + ". " + array);
        return min;
    }

    @Override
    public int findSumStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int sum = Arrays.stream(elements).sum();
        LOGGER.info("Sum = " + sum + ". " + array);
        return sum;
    }

    @Override
    public OptionalDouble findAverageStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        OptionalDouble average = Arrays.stream(elements).average();
        LOGGER.info("Average = " + average + ". " + array);
        return average;
    }

    @Override
    public int findNumberOfPositiveStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int numberOfPositive = (int) Arrays.stream(elements).filter((x) -> x > 0).count();
        LOGGER.info("Number of positive = " + numberOfPositive + ". " + array);
        return numberOfPositive;
    }

    @Override
    public int findNumberOfNegativeStream(CustomArray array) throws CustomArrayException {
        if (array == null || array.getElements() == null) {
            LOGGER.error("CustomArray is null or field elements is null");
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        int numberOfNegative = (int) Arrays.stream(elements).filter((x) -> x < 0).count();
        LOGGER.info("Number of negative = " + numberOfNegative + ". " + array);
        return numberOfNegative;
    }

}

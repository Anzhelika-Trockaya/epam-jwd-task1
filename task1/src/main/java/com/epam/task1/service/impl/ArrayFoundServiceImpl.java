package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task1.service.ArrayFoundService;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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
    public int foundSumOfElements(CustomArray array) throws CustomArrayException {
        LOGGER.info("found sum of elements");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return 0;
        }
        int sum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (Integer.MAX_VALUE - sum >= Math.abs(elements[i])) {//fixme
                sum += elements[i];
            } else {
                LOGGER.error("sum value is bigger than Integer.MAX_VALUE");
                throw new CustomArrayException("sum value is bigger than Integer.MAX_VALUE");
            }
        }
        return sum;
    }

    @Override
    public OptionalDouble foundAverage(CustomArray array) throws CustomArrayException {
        LOGGER.info("found average");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return OptionalDouble.empty();
        }
        int sumOfElements = foundSumOfElements(array);
        double average;
        if (Double.MAX_VALUE >= Math.abs(sumOfElements / elements.length)) {//fixme
            average = (double) sumOfElements / elements.length;
        } else {
            LOGGER.error("Average is bigger than Double.MAX_VALUE");
            throw new CustomArrayException("Average is bigger than Double.MAX_VALUE");
        }
        return OptionalDouble.of(average);
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

    @Override
    public OptionalInt foundMaxStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found max element using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.max();
    }

    @Override
    public OptionalInt foundMinStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found min element using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.min();
    }

    @Override
    public int foundSumOfElementsStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found sum of elements using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.sum();
    }

    @Override
    public OptionalDouble foundAverageStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found average using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.average();
    }

    @Override
    public int foundNumberOfPositiveStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found number of positive using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return (int) stream.filter((x) -> x > 0).count();
    }

    @Override
    public int foundNumberOfNegativeStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("found number of negative using stream");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return (int) stream.filter((x) -> x < 0).count();
    }

}

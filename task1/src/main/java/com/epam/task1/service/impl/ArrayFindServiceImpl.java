package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayFindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayFindServiceImpl implements ArrayFindService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayFindServiceImpl.class.getName());

    @Override
    public OptionalInt findMax(CustomArray array) throws CustomArrayException {
        LOGGER.info("find max element");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
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
    public OptionalInt findMin(CustomArray array) throws CustomArrayException {
        LOGGER.info("find min element");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
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
    public int findSum(CustomArray array) throws CustomArrayException {
        LOGGER.info("find sum of elements");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return 0;
        }
        int sum = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (Integer.MAX_VALUE - sum >= Math.abs(elements[i])) {
                sum += elements[i];
            } else {
                LOGGER.error("sum value is bigger than Integer.MAX_VALUE");
                throw new CustomArrayException("sum value is bigger than Integer.MAX_VALUE");
            }
        }
        return sum;
    }

    @Override
    public OptionalDouble findAverage(CustomArray array) throws CustomArrayException {
        LOGGER.info("find average");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return OptionalDouble.empty();
        }
        int sumOfElements = findSum(array);
        double average = (double) sumOfElements / elements.length;
        return OptionalDouble.of(average);
    }

    @Override
    public int findNumberOfPositive(CustomArray array) throws CustomArrayException {
        LOGGER.info("find number of positive elements");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
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
    public int findNumberOfNegative(CustomArray array) throws CustomArrayException {
        LOGGER.info("find number of negative elements");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
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
    public OptionalInt findMaxStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find max element using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.max();
    }

    @Override
    public OptionalInt findMinStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find min element using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.min();
    }

    @Override
    public int findSumStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find sum of elements using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.sum();
    }

    @Override
    public OptionalDouble findAverageStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find average using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return stream.average();
    }

    @Override
    public int findNumberOfPositiveStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find number of positive using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return (int) stream.filter((x) -> x > 0).count();
    }

    @Override
    public int findNumberOfNegativeStream(CustomArray array) throws CustomArrayException {
        LOGGER.info("find number of negative using stream");
        if (array == null || array.getElements() == null) {
            throw new CustomArrayException("CustomArray is null or field elements is null");
        }
        int[] elements = array.getElements();
        IntStream stream = Arrays.stream(elements);
        return (int) stream.filter((x) -> x < 0).count();
    }

}

package com.epam.task1.service.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.task1.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {
    private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class.getName());

    @Override
    public void bubbleSort(CustomArray array) throws CustomArrayException {
        LOGGER.info("bubble sort array");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    isSorted = false;
                    buf = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = buf;
                }
            }
        }
        array.setElements(elements);
    }

    @Override
    public void insertionSort(CustomArray array) throws CustomArrayException {
        LOGGER.info("insertion sort array");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int tempIndex;
        int currentValue;
        for (int i = 1; i < elements.length; i++) {
            currentValue = elements[i];
            tempIndex = searchInsertIndex(elements, i - 1, currentValue);
            for (int j = i; j > tempIndex; j--) {
                elements[j] = elements[j - 1];
            }
            elements[tempIndex] = currentValue;
        }
        array.setElements(elements);
    }

    @Override
    public void shellSort(CustomArray array) throws CustomArrayException {
        LOGGER.info("shell sort array");
        ArrayChecker checker = new ArrayChecker();
        checker.checkArray(array);
        int[] elements = array.getElements();
        int buf;
        for (int i = 0; i < elements.length - 1;) {
            if (elements[i] > elements[i + 1]) {
                buf = elements[i];
                elements[i] = elements[i + 1];
                elements[i + 1] = buf;
                if (i != 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        array.setElements(elements);
    }

    private static int searchInsertIndex(int[] elements, int lastIndex, int valueForInsert) {
        LOGGER.info("search insert index");
        int firstIndex = 0;
        int middleIndex;
        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            if (elements[middleIndex] == valueForInsert) {
                return middleIndex;
            } else if (elements[middleIndex] < valueForInsert) {
                firstIndex = middleIndex + 1;
            } else if (elements[middleIndex] > valueForInsert) {
                lastIndex = middleIndex - 1;
            }
        }
        return firstIndex;
    }

}

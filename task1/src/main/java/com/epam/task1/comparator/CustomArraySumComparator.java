package com.epam.task1.comparator;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class CustomArraySumComparator implements Comparator<CustomArray> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int sum1 = calculateSum(o1);
        int sum2 = calculateSum(o2);
        return Integer.compare(sum1, sum2);
    }

    private int calculateSum(CustomArray array) {
        ArrayFindService findService = new ArrayFindServiceImpl();
        int sum = Integer.MIN_VALUE;
        try {
            sum = findService.findSum(array);
        } catch (CustomArrayException customArrayException) {
            LOGGER.warn("Sum not calculated", customArrayException);
        }
        return sum;
    }
}

package com.epam.task1.util.comparator;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.OptionalDouble;

public class CustomArrayAverageComparator implements Comparator<CustomArray> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        double average1 = calculateAverage(o1);
        double average2 = calculateAverage(o2);
        return Double.compare(average1, average2);
    }

    private double calculateAverage(CustomArray array) {
        double average = Double.MIN_VALUE;
        ArrayFindService findService = new ArrayFindServiceImpl();
        try {
            OptionalDouble averageOptional = findService.findAverage(array);
            if (averageOptional.isPresent()) {
                average = averageOptional.getAsDouble();
            } else {
                LOGGER.warn("Average optional is empty" + averageOptional);
            }
        } catch (CustomArrayException customArrayException) {
            LOGGER.warn("Average not calculated", customArrayException);
        }
        return average;

    }
}

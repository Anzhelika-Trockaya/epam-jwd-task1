package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.repository.specification.Specification;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class AverageBiggerSpecification implements Specification {
    private static final Logger LOGGER = LogManager.getLogger();
    private final double value;

    public AverageBiggerSpecification(double value) {
        this.value = value;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        ArrayFindService findService = new ArrayFindServiceImpl();
        try {
            OptionalDouble averageOptional = findService.findAverage(customArray);
            if (averageOptional.isPresent()) {
                double average = averageOptional.getAsDouble();
                result = (average > value);
            } else {
                LOGGER.warn("Average optional is empty" + averageOptional);
            }
        } catch (CustomArrayException customArrayException) {
            LOGGER.warn("Average is not calculated", customArrayException);
        }
        return result;
    }
}

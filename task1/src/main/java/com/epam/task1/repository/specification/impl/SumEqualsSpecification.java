package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.repository.specification.Specification;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumEqualsSpecification implements Specification {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int value;

    public SumEqualsSpecification(int value) {
        this.value = value;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        ArrayFindService findService = new ArrayFindServiceImpl();
        try {
            int sum = findService.findSum(customArray);
            result = (sum == value);
        } catch (CustomArrayException customArrayException) {
            LOGGER.warn("Sum not calculated", customArrayException);
        }
        return result;
    }
}

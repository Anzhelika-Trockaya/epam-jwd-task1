package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.repository.specification.Specification;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class MaxLessSpecification implements Specification {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int value;

    public MaxLessSpecification(int value) {
        this.value = value;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        boolean result = false;
        ArrayFindService findService = new ArrayFindServiceImpl();
        try {
            OptionalInt maxOptional = findService.findMax(customArray);
            if (maxOptional.isPresent()) {
                int max = maxOptional.getAsInt();
                result = (max < value);
            } else {
                LOGGER.warn("Max optional is empty" + maxOptional);
            }
        } catch (CustomArrayException customArrayException) {
            LOGGER.warn("Max is not calculated", customArrayException);
        }
        return result;
    }
}

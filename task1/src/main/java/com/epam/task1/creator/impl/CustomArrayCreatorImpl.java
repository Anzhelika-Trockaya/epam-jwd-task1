package com.epam.task1.creator.impl;

import com.epam.task1.creator.CustomArrayCreator;
import com.epam.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayCreatorImpl implements CustomArrayCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public CustomArray createCustomArray(int[] elements) {
        LOGGER.info("create new CustomArray");
        return new CustomArray(elements);
    }

    @Override
    public CustomArray createCustomArray() {
        LOGGER.info("create new CustomArray");
        return new CustomArray();
    }

    @Override
    public List<CustomArray> createCustomArrays(List<int[]> arraysElements) {
        LOGGER.info("create new CustomArray");
        List<CustomArray> customArrays = new ArrayList<>();
        if (arraysElements == null) {
            return customArrays;
        }
        for (int[] elements : arraysElements) {
            customArrays.add(new CustomArray(elements));
        }
        return customArrays;
    }
}

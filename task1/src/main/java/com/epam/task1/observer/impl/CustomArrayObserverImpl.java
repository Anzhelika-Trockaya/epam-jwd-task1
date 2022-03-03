package com.epam.task1.observer.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.entity.CustomArrayParameters;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.observer.CustomArrayEvent;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import com.epam.task1.entity.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayObserverImpl implements com.epam.task1.observer.CustomArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void updateCustomArrayParams(CustomArrayEvent event) {
        ArrayFindService arrayFindService = new ArrayFindServiceImpl();
        try {
            CustomArray array = event.getSource();
            int sum = arrayFindService.findSum(array);
            OptionalInt min = arrayFindService.findMin(array);
            OptionalInt max = arrayFindService.findMax(array);
            OptionalDouble average = arrayFindService.findAverage(array);
            CustomArrayParameters params = new CustomArrayParameters(max, min, sum, average);
            int id = array.getId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(id, params);
        } catch (CustomArrayException customArrayException) {
            LOGGER.error("data were not refreshed. " + event, customArrayException);
        }
        LOGGER.info("CustomArray params updated." + event);
    }
}

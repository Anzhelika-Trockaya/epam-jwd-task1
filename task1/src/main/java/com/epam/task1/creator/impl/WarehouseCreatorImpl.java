package com.epam.task1.creator.impl;

import com.epam.task1.creator.WarehouseCreator;
import com.epam.task1.entity.CustomArray;
import com.epam.task1.entity.CustomArrayParameters;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class WarehouseCreatorImpl implements WarehouseCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Warehouse createWarehouse(List<CustomArray> arrays) {
        Warehouse warehouse = Warehouse.getInstance();
        ArrayFindService findService = new ArrayFindServiceImpl();
        for (CustomArray array : arrays) {
            try {
                int sum = findService.findSum(array);
                OptionalInt max = findService.findMax(array);
                OptionalInt min = findService.findMin(array);
                OptionalDouble average = findService.findAverage(array);
                CustomArrayParameters params = new CustomArrayParameters(max, min, sum, average);
                int id = array.getId();
                warehouse.put(id, params);
            } catch (CustomArrayException exception) {
                LOGGER.warn("Params of array:" + array + "not added", exception);
            }
        }
        return warehouse;
    }

}

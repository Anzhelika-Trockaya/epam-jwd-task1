package com.epam.task1.creator;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.entity.Warehouse;

import java.util.List;

public interface WarehouseCreator {
    Warehouse createWarehouse(List<CustomArray> arrays);
}

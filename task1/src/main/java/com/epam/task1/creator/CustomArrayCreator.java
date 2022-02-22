package com.epam.task1.creator;

import com.epam.task1.entity.CustomArray;

import java.util.List;

public interface CustomArrayCreator {
    CustomArray createCustomArray(int[] elements);
    CustomArray createCustomArray();
    List<CustomArray> createCustomArrays(List<int[]> arraysElements);
}

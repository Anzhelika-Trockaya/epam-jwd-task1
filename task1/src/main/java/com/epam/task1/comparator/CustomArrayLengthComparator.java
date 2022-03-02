package com.epam.task1.comparator;

import com.epam.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayLengthComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        int result = Integer.compare(o1.length(), o2.length());
        return result;
    }
}

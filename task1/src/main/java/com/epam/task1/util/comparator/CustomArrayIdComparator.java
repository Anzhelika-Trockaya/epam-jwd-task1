package com.epam.task1.util.comparator;

import com.epam.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

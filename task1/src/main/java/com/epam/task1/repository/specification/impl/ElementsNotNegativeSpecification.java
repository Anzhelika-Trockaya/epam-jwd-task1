package com.epam.task1.repository.specification.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.specification.Specification;

public class ElementsNotNegativeSpecification implements Specification {
    @Override
    public boolean specify(CustomArray customArray) {
        int[] elements = customArray.getElements();
        if (elements.length == 0) {
            return false;
        }
        for (int element : elements) {
            if (element < 0) {
                return false;
            }
        }
        return true;
    }
}

package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

public interface ArrayChangeService {
    void replaceAll(CustomArray array, int value, int replacement) throws CustomArrayException;

    void replaceAllGreaterThanValue(CustomArray array, int value, int replacement) throws CustomArrayException;

    void replaceAllLessThanValue(CustomArray array, int value, int replacement) throws CustomArrayException;

    void replaceAllNegative(CustomArray array, int replacement) throws CustomArrayException;

    void replaceAllInInterval(CustomArray array, int startIndex, int intervalLength, int replacement) throws CustomArrayException;
}


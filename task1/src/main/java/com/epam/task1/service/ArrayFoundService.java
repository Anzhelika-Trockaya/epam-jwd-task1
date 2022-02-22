package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

public interface ArrayFoundService {

    int foundMax(CustomArray array) throws CustomArrayException;

    int foundMin(CustomArray array) throws CustomArrayException;

    long foundSumOfElements(CustomArray array) throws CustomArrayException;

    int foundNumberOfPositive(CustomArray array) throws CustomArrayException;

    int foundNumberOfNegative(CustomArray array) throws CustomArrayException;
}

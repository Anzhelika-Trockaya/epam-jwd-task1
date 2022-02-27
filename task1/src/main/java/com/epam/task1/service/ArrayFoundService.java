package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayFoundService {

    OptionalInt foundMax(CustomArray array) throws CustomArrayException;

    OptionalInt foundMin(CustomArray array) throws CustomArrayException;

    int foundSumOfElements(CustomArray array) throws CustomArrayException;

    OptionalDouble foundAverage(CustomArray array) throws CustomArrayException;

    int foundNumberOfPositive(CustomArray array) throws CustomArrayException;

    int foundNumberOfNegative(CustomArray array) throws CustomArrayException;

    OptionalInt foundMaxStream(CustomArray array) throws CustomArrayException;

    OptionalInt foundMinStream(CustomArray array) throws CustomArrayException;

    int foundSumOfElementsStream(CustomArray array) throws CustomArrayException;

    OptionalDouble foundAverageStream(CustomArray array) throws CustomArrayException;

    int foundNumberOfPositiveStream(CustomArray array) throws CustomArrayException;

    int foundNumberOfNegativeStream(CustomArray array) throws CustomArrayException;
}

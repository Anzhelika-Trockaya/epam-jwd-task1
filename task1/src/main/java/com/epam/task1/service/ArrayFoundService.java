package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayFoundService {

    OptionalInt foundMax(CustomArray array) throws CustomArrayException;

    OptionalInt foundMin(CustomArray array) throws CustomArrayException;

    OptionalLong foundSumOfElements(CustomArray array) throws CustomArrayException;

    int foundNumberOfPositive(CustomArray array) throws CustomArrayException;

    int foundNumberOfNegative(CustomArray array) throws CustomArrayException;
}

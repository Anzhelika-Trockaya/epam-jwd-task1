package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayFindService {

    OptionalInt findMax(CustomArray array) throws CustomArrayException;

    OptionalInt findMin(CustomArray array) throws CustomArrayException;

    int findSum(CustomArray array) throws CustomArrayException;

    OptionalDouble findAverage(CustomArray array) throws CustomArrayException;

    int findNumberOfPositive(CustomArray array) throws CustomArrayException;

    int findNumberOfNegative(CustomArray array) throws CustomArrayException;

    OptionalInt findMaxStream(CustomArray array) throws CustomArrayException;

    OptionalInt findMinStream(CustomArray array) throws CustomArrayException;

    int findSumStream(CustomArray array) throws CustomArrayException;

    OptionalDouble findAverageStream(CustomArray array) throws CustomArrayException;

    int findNumberOfPositiveStream(CustomArray array) throws CustomArrayException;

    int findNumberOfNegativeStream(CustomArray array) throws CustomArrayException;
}

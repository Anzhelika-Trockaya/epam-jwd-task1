package com.epam.task1.service;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;

public interface ArraySortService {

    void bubbleSort(CustomArray array) throws CustomArrayException;

    void insertionSort(CustomArray array) throws CustomArrayException;

    void shellSort(CustomArray array) throws CustomArrayException;

    void selectionSort(CustomArray array) throws CustomArrayException;
}
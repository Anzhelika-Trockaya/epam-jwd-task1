package com.epam.jwd.task1.service;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public interface ArraySortService {

    void bubbleSort(CustomArray array) throws ServiceException;

    void insertionSort(CustomArray array) throws ServiceException;

    void shellSort(CustomArray array) throws ServiceException;

    void selectionSort(CustomArray array) throws ServiceException;
}
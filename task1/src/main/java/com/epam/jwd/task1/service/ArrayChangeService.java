package com.epam.jwd.task1.service;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public interface ArrayChangeService {
    void replaceAll(CustomArray array, int value, int replacement) throws ServiceException;

    void replaceAllGreaterThanValue(CustomArray array, int value, int replacement) throws ServiceException;

    void replaceAllLessThanValue(CustomArray array, int value, int replacement) throws ServiceException;

    void replaceAllNegative(CustomArray array, int value) throws ServiceException;

    void replaceAllInInterval(CustomArray array, int startIndex, int intervalLength, int value) throws ServiceException;
}


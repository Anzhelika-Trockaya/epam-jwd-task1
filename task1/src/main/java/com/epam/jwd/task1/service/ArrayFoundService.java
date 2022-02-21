package com.epam.jwd.task1.service;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.ServiceException;

public interface ArrayFoundService {

    int foundMax(CustomArray array) throws ServiceException;

    int foundMin(CustomArray array) throws ServiceException;

    long foundSumOfElements(CustomArray array) throws ServiceException;

    int foundNumberOfPositive(CustomArray array) throws ServiceException;

    int foundNumberOfNegative(CustomArray array) throws ServiceException;
}

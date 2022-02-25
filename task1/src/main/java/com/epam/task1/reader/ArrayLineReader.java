package com.epam.task1.reader;

import com.epam.task1.exception.CustomArrayException;

import java.util.List;

public interface ArrayLineReader {
    List<String> readAllArrayLines(String fileName) throws CustomArrayException;
}

package com.epam.task1.reader;

import com.epam.task1.exception.CustomArrayException;

import java.util.List;

public interface ArrayLineReader {
    String readFirstArrayLine(String fileName) throws CustomArrayException;

    List<String> readAllArrayLines(String fileName) throws CustomArrayException;
}

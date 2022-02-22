package com.epam.task1.parser;

import com.epam.task1.exception.CustomArrayException;

import java.util.List;

public interface ArrayParser {
    int[] parse(String line) throws CustomArrayException;

    List<int[]> parseAll(List<String> lines) throws CustomArrayException;
}

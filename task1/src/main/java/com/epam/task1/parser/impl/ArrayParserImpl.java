package com.epam.task1.parser.impl;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.parser.ArrayParser;
import com.epam.task1.validation.ArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPLITTER_REGEX = ";";

    public int[] parse(String line) throws CustomArrayException {
        LOGGER.info("parse line='" + line + "'");
        validate(line);
        line = line.replaceAll("\\s", "");
        int[] arrayElements;
        if (!line.isEmpty()) {
            String[] lineParts = line.split(SPLITTER_REGEX);
            arrayElements = parseIntArrayFromStringArray(lineParts);
        } else {
            arrayElements = new int[0];
        }
        return arrayElements;
    }


    @Override
    public List<int[]> parseAll(List<String> lines) throws CustomArrayException {
        LOGGER.info("parse line list");
        validate(lines);
        List<int[]> arrays = new ArrayList<>();
        int[] currentArray;
        for (String line : lines) {
            currentArray = parse(line);
            arrays.add(currentArray);
        }
        return arrays;
    }

    private void validate(String line) throws CustomArrayException {
        ArrayLineValidator validator = ArrayLineValidator.getInstance();
        if (!validator.isArrayLineCorrect(line)) {
            LOGGER.error("Incorrect line");
            throw new CustomArrayException("Incorrect line: '" + line + "'");
        }
    }

    private void validate(List<String> lines) throws CustomArrayException {
        if (lines == null || lines.isEmpty()) {
            LOGGER.error("Incorrect line list");
            throw new CustomArrayException("Line list is null or empty");
        }
        for (String line : lines) {
            validate(line);
        }
    }

    private int[] parseIntArrayFromStringArray(String[] strings) {
        LOGGER.debug("parse int[] from String[]");
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }
}

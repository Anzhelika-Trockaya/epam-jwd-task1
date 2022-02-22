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
    private static final String SPLITTER_REGEX = "\\s*;\\s*";

    public int[] parse(String line) throws CustomArrayException {
        LOGGER.info("parse line='" + line + "'");
        validate(line);
        if (line.startsWith(" ") || line.endsWith(" ")) {
            line = deleteSpacesFromStartAndEnd(line);
        }
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
        ArrayLineValidator validator = new ArrayLineValidator();
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

    private String deleteSpacesFromStartAndEnd(String line) {
        LOGGER.debug("delete spaces from start and end");
        if (line.isBlank()) {
            return new String();
        }
        int startIndex = foundFirstNotSpaceCharIndex(line);
        int endIndex = foundLastNotSpaceCharIndex(line) + 1;
        String newLine = line.substring(startIndex, endIndex);
        return newLine;
    }

    private int foundLastNotSpaceCharIndex(String line) {
        LOGGER.debug("found last not space char index");
        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
    }

    private int foundFirstNotSpaceCharIndex(String line) {
        LOGGER.debug("found first not space char index");
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
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

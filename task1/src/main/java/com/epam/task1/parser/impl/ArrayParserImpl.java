package com.epam.task1.parser.impl;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.parser.ArrayParser;
import com.epam.task1.validation.ArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPLITTER_REGEX = ";";

    @Override
    public int[] parse(String line) {
        LOGGER.info("parse line='" + line + "'");
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
    public List<int[]> parseAll(List<String> lines) {
        LOGGER.info("parse line list");
        List<int[]> arrays = new ArrayList<>();
        int[] currentArray;
        for (String line : lines) {
            currentArray = parse(line);
            arrays.add(currentArray);
        }
        return arrays;
    }

    @Override
    public int[] parseStream(String line) {
        LOGGER.info("parse line='" + line + "' using stream");
        if (line.isBlank()) {
            return new int[0];
        }
        line = line.replaceAll("\\s", "");
        String[] lineParts = line.split(SPLITTER_REGEX);
        return Arrays.stream(lineParts)
                .mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public List<int[]> parseAllStream(List<String> lines) {
        LOGGER.info("parse line list using stream");
        return lines.stream()
                .map(this::parseStream)
                .collect(Collectors.toList());
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

package com.epam.task1.parser.impl;

import com.epam.task1.parser.ArrayParser;
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
        line = line.replaceAll("\\s", "");
        int[] array;
        if (!line.isEmpty()) {
            String[] lineParts = line.split(SPLITTER_REGEX);
            array = parseIntArrayFromStringArray(lineParts);
        } else {
            array = new int[0];
        }
        LOGGER.info("Array from line='" + line + "' parsed. " + Arrays.toString(array));
        return array;
    }


    @Override
    public List<int[]> parseAll(List<String> lines) {
        List<int[]> arrays = new ArrayList<>();
        int[] currentArray;
        for (String line : lines) {
            currentArray = parse(line);
            arrays.add(currentArray);
        }
        LOGGER.info("Arrays list parsed." + arrays);
        return arrays;
    }

    @Override
    public int[] parseStream(String line) {
        if (line.isBlank()) {
            return new int[0];
        }
        line = line.replaceAll("\\s", "");
        String[] lineParts = line.split(SPLITTER_REGEX);
        int[] array = Arrays.stream(lineParts).mapToInt(Integer::parseInt).toArray();
        LOGGER.info("Array from line='" + line + "' parsed. " + Arrays.toString(array));
        return array;
    }

    @Override
    public List<int[]> parseAllStream(List<String> lines) {
        List<int[]> arrays = lines.stream()
                .map(this::parseStream)
                .collect(Collectors.toList());
        LOGGER.info("Arrays list parsed." + arrays);
        return arrays;
    }

    private int[] parseIntArrayFromStringArray(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        LOGGER.debug("parse int[] from String[]: " + Arrays.toString(ints));
        return ints;
    }
}

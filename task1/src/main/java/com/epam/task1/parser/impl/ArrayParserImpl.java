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

    @Override
    public int[] parseStream(String line) throws CustomArrayException {
        LOGGER.info("parse line='" + line + "' using stream");
        validate(line);
        if (line.isBlank()) {
            return new int[0];
        }
        line = line.replaceAll("\\s", "");
        String[] lineParts = line.split(SPLITTER_REGEX);
        return Arrays.stream(lineParts)
                .mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public List<int[]> parseAllStream(List<String> lines) throws CustomArrayException {
        LOGGER.info("parse line list using stream");
        validate(lines);
        for (String line : lines) {
            validate(line);
        }
        /*
        List<String[]> correctLines = lines.stream()
                .map((x) -> x.replaceAll("\\s", ""))
                .map((x) -> x.split(SPLITTER_REGEX))
                .collect(Collectors.toList());
        List<int[]> arrays = correctLines.stream()
                .map((x) -> (x.length > 1 || !x[0].isBlank()) ? (Arrays.stream(x).mapToInt(Integer::parseInt).toArray()) : new int[0])
                .collect(Collectors.toList());*/
        List<int[]> arrays = lines.stream()
                .map((x) -> {
                    try {
                        return parseStream(x);
                    } catch (CustomArrayException exception) {
                        LOGGER.warn("line is invalid");//todo: is correct? (delete comment)
                        return null;
                    }
                })
                .collect(Collectors.toList());
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
        if (lines == null) {
            LOGGER.error("Line list is null");
            throw new CustomArrayException("Line list is null");
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

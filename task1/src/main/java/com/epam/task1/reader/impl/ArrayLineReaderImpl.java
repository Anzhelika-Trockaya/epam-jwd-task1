package com.epam.task1.reader.impl;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.reader.ArrayLineReader;
import com.epam.task1.validation.ArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ArrayLineReaderImpl implements ArrayLineReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readAllArrayLines(String fileName) throws CustomArrayException {
        checkFile(fileName);
        List<String> lines = new ArrayList<>();
        String currentLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                currentLine = findNextArrayLine(bufferedReader);
                if (currentLine != null) {
                    lines.add(currentLine);
                }
            }
        } catch (IOException ioException) {
            LOGGER.error("Exception when use BufferedReader object", ioException);
            throw new CustomArrayException(ioException);
        }
        LOGGER.info("All array strings read."+ lines);
        return lines;
    }

    @Override
    public List<String> readAllArrayLinesStream(String fileName) throws CustomArrayException {
        checkFile(fileName);
        Stream<String> stream;
        try {
            stream = Files.lines(Paths.get(fileName));
        } catch (IOException ioException) {
            LOGGER.error("Exception when read from file", ioException);
            throw new CustomArrayException(ioException);
        }
        ArrayLineValidator validator = ArrayLineValidator.getInstance();
        List<String> lines = stream.filter(validator::isArrayLineCorrect).collect(Collectors.toList());
        LOGGER.info("Array lines read."+lines);
        return lines;
    }

    private void checkFile(String fileName) throws CustomArrayException {
        if (fileName == null || fileName.isBlank()) {
            LOGGER.error("fileName is null or empty string");
            throw new CustomArrayException("Incorrect file name");
        }
        if (Files.notExists(Paths.get(fileName))) {
            LOGGER.error("File with name '" + fileName + "' does not exist");
            throw new CustomArrayException("File with name '" + fileName + "' does not exist");
        }
        if (!Files.isReadable(Paths.get(fileName))) {
            LOGGER.error("File with name '" + fileName + "' is not readable");
            throw new CustomArrayException("File with name '" + fileName + "' is not readable");
        }
        LOGGER.debug("File "+fileName+" exists and is readable.");
    }

    private String findNextArrayLine(BufferedReader bufferedReader) throws IOException {
        String currentLine;
        while (bufferedReader.ready()) {
            currentLine = bufferedReader.readLine();
            ArrayLineValidator validator = ArrayLineValidator.getInstance();
            if (validator.isArrayLineCorrect(currentLine)) {
                LOGGER.debug("Next array line='"+currentLine+"'");
                return currentLine;
            }
        }
        LOGGER.debug("File has no more lines");
        return null;
    }
}


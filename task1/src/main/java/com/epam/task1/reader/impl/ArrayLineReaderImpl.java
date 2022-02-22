package com.epam.task1.reader.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.reader.ArrayLineReader;
import com.epam.task1.validation.ArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayLineReaderImpl implements ArrayLineReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public String readFirstArrayLine(String fileName) throws CustomArrayException {
        LOGGER.info("read first array string");
        checkFile(fileName);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            line = foundNextArrayLine(bufferedReader);
        } catch (IOException ioException) {
            LOGGER.error("Exception when use BufferedReader object");
            throw new CustomArrayException(ioException);
        }
        if (line == null) {
            LOGGER.error("file has no valid lines");
            throw new CustomArrayException("file has no valid lines");
        }
        return line;
    }

    public List<String> readAllArrayLines(String fileName) throws CustomArrayException {
        LOGGER.info("read all array strings");
        checkFile(fileName);
        List<String> lines = new ArrayList<>();
        String currentLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                currentLine = foundNextArrayLine(bufferedReader);
                if (currentLine != null) {
                    lines.add(currentLine);
                }
            }
        } catch (IOException ioException) {
            LOGGER.error("Exception when use BufferedReader object");
            throw new CustomArrayException(ioException);
        }
        if (lines.isEmpty()) {
            LOGGER.error("file has no valid lines");
            throw new CustomArrayException("file has no valid lines");
        }
        return lines;
    }

    private void checkFile(String fileName) throws CustomArrayException {
        LOGGER.debug("checkFileName");
        if (fileName == null || fileName.isBlank()) {
            LOGGER.error("fileName is null or empty string");
            throw new CustomArrayException("Incorrect file name");
        }
        if (Files.notExists(Paths.get(fileName))) {
            LOGGER.error("file is not exist");
            throw new CustomArrayException("File with name '" + fileName + "' does not exist");
        }
       /* if (Files.isReadable(Paths.get(fileName))) {
            LOGGER.error("file is not readable");
            throw new CustomArrayException("File with name '" + fileName + "' is not readable");
        }*/
    }

    private String foundNextArrayLine(BufferedReader bufferedReader) throws CustomArrayException {
        LOGGER.info("found next array line");
        String currentLine;
        try {
            while (bufferedReader.ready()) {
                currentLine = bufferedReader.readLine();
                ArrayLineValidator validator = new ArrayLineValidator();
                if (validator.isArrayLineCorrect(currentLine)) {
                    return currentLine;
                }
            }
        } catch (IOException exception) {
            LOGGER.error("Exception when use BufferedReader object");
            throw new CustomArrayException(exception);
        }
        return null;
    }
}

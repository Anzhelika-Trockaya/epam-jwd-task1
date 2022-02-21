package com.epam.jwd.task1.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task1.entity.CustomArray;
import com.epam.jwd.task1.exception.CustomArrayParseException;
import com.epam.jwd.task1.exception.CustomArrayReaderException;
import com.epam.jwd.task1.exception.FileNotExistsException;
import com.epam.jwd.task1.parser.CustomArrayParser;
import com.epam.jwd.task1.validation.CustomArrayLineValidator;

public class CustomArrayReader {
    private static final Logger LOGGER = LogManager.getLogger(CustomArrayReader.class.getName());
    private BufferedReader bufferedReader;
    private String nextArrayLine;

    public CustomArrayReader(String fileName) throws IOException, FileNotExistsException, CustomArrayReaderException {
        LOGGER.info("creating new CustomArrayReader()");
        if (fileName == null) {
            throw new CustomArrayReaderException("FileName is null");
        }
        if (Files.exists(Path.of(fileName))) {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } else {
            throw new FileNotExistsException("fileName = " + fileName);
        }
    }

    public CustomArray readNext() throws CustomArrayReaderException, CustomArrayParseException {
        LOGGER.info("read next CustomArray");
        CustomArray customArray = null;
        if (hasNext()) {
            CustomArrayParser parser = new CustomArrayParser();
            customArray = parser.parse(nextArrayLine);
            nextArrayLine = null;
        }
        return customArray;
    }

    public boolean hasNext() throws CustomArrayReaderException {
        LOGGER.info("has next CustomArrayLine");
        if (nextArrayLine == null) {
            foundNextArrayLine();
        }
        return nextArrayLine != null;
    }

    private void foundNextArrayLine() throws CustomArrayReaderException {
        LOGGER.info("found next array line");
        String currentLine;
        try {
            LOGGER.info("try");
            while (bufferedReader.ready()) {
                currentLine = bufferedReader.readLine();
                CustomArrayLineValidator validator = new CustomArrayLineValidator();
                if (validator.isCustomArrayLineCorrect(currentLine)) {
                    nextArrayLine = currentLine;
                    return;
                }
            }
        } catch (IOException exception) {
            LOGGER.debug("throw new CustomArrayReaderException");
            throw new CustomArrayReaderException(exception);
        }
    }

    public void close() throws Exception {
        LOGGER.info("close");
        try {
            LOGGER.info("try");
            bufferedReader.close();
        } catch (Exception exception) {
            LOGGER.debug("throw new CustomArrayReaderException");
            throw new CustomArrayReaderException(exception);
        }
    }
}


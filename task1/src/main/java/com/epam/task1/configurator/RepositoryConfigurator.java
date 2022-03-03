package com.epam.task1.configurator;

import com.epam.task1.creator.CustomArrayCreator;
import com.epam.task1.creator.impl.CustomArrayCreatorImpl;
import com.epam.task1.entity.CustomArray;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.parser.ArrayParser;
import com.epam.task1.parser.impl.ArrayParserImpl;
import com.epam.task1.reader.ArrayLineReader;
import com.epam.task1.reader.impl.ArrayLineReaderImpl;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.impl.RepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RepositoryConfigurator {
    private static final Logger LOGGER = LogManager.getLogger();
    public RepositoryConfigurator(){
    }
    public Repository configure(String fileName){
        ArrayLineReader reader = new ArrayLineReaderImpl();
        Repository repository = RepositoryImpl.getInstance();
        try {
            List<String> lines = reader.readAllArrayLines(fileName);
            ArrayParser parser = new ArrayParserImpl();
            List<int[]> arrays =  parser.parseAll(lines);
            CustomArrayCreator creator = new CustomArrayCreatorImpl();
            List<CustomArray> customArrays = creator.createCustomArrays(arrays);
            repository.addAll(customArrays);
        } catch(CustomArrayException exception){
            LOGGER.error("Repository not configured", exception);
        }
        return repository;
    }
}

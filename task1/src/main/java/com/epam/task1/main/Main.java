package com.epam.task1.main;

import com.epam.task1.configurator.RepositoryConfigurator;
import com.epam.task1.configurator.WarehouseConfigurator;
import com.epam.task1.entity.CustomArray;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.observer.CustomArrayObserver;
import com.epam.task1.observer.impl.CustomArrayObserverImpl;
import com.epam.task1.repository.Repository;
import com.epam.task1.service.ArrayChangeService;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        final String fileSimpleName = "arraysFile.txt";
        ClassLoader loader = Main.class.getClassLoader();
        URL fileURI = loader.getResource(fileSimpleName);
        if (fileURI == null) {
            return;
        }
        String fileName = fileURI.toString().substring(6);
        RepositoryConfigurator repositoryConfigurator = new RepositoryConfigurator();
        Repository repository = repositoryConfigurator.configure(fileName);
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        repository.forEach((x)->x.attach(observer));
        WarehouseConfigurator warehouseConfigurator = new WarehouseConfigurator();
        Warehouse warehouse = warehouseConfigurator.configure(repository.getAll());
        CustomArray array = repository.get(0);
        ArrayChangeService changeService = new ArrayChangeServiceImpl();
        try {
            changeService.replaceAll(array, 1, 10000);
        } catch (CustomArrayException customArrayException) {
            LOGGER.error("Exception",customArrayException);
        }
    }
}

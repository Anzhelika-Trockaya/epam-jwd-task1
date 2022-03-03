package com.epam.task1.main;

import com.epam.task1.configurator.RepositoryConfigurator;
import com.epam.task1.configurator.WarehouseConfigurator;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.repository.Repository;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        final String fileSimpleName = "arraysFile.txt";
        ClassLoader loader = Main.class.getClassLoader();
        URL fileURI = loader.getResource(fileSimpleName);
        if (fileURI == null) {
            return;
        }
        String fileName = fileURI.toString().substring(6);
        RepositoryConfigurator repositoryConfigurator = new RepositoryConfigurator();
        WarehouseConfigurator warehouseConfigurator = new WarehouseConfigurator();
        Repository repository = repositoryConfigurator.configure(fileName);
        Warehouse warehouse = warehouseConfigurator.configure(repository.getAll());
    }
}

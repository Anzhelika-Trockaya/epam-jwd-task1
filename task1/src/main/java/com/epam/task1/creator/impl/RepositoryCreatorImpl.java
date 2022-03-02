package com.epam.task1.creator.impl;

import com.epam.task1.creator.RepositoryCreator;
import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.impl.RepositoryImpl;

import java.util.List;

public class RepositoryCreatorImpl implements RepositoryCreator {
    @Override
    public Repository createRepository(List<CustomArray> arrays) {
        Repository repository = RepositoryImpl.getInstance();
        repository.addAll(arrays);
        return repository;
    }
}

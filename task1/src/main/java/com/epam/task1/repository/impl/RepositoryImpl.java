package com.epam.task1.repository.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {
    private static RepositoryImpl instance;
    private final List<CustomArray> CUSTOM_ARRAYS;

    private RepositoryImpl() {
        CUSTOM_ARRAYS = new ArrayList<>();
    }

    public static RepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public boolean add(CustomArray customArray) {
        return CUSTOM_ARRAYS.add(customArray);
    }

    @Override
    public boolean addAll(Collection<CustomArray> collection) {
        return CUSTOM_ARRAYS.addAll(collection);
    }

    @Override
    public boolean remove(CustomArray customArray) {
        return CUSTOM_ARRAYS.remove(customArray);
    }

    @Override
    public boolean removeAll(Collection<CustomArray> collection) {
        return CUSTOM_ARRAYS.removeAll(collection);
    }

    @Override
    public CustomArray get(int index) {
        return CUSTOM_ARRAYS.get(index);
    }

    @Override
    public CustomArray set(int index, CustomArray customArray) {
        return CUSTOM_ARRAYS.set(index, customArray);
    }

    @Override
    public List<CustomArray> getAll() {
        return CUSTOM_ARRAYS;
    }

    @Override
    public void forEach(Consumer<? super CustomArray> action) {
        CUSTOM_ARRAYS.forEach(action);
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        return CUSTOM_ARRAYS.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        return CUSTOM_ARRAYS.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}

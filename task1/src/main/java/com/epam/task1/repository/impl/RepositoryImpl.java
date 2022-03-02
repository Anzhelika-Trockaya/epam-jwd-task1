package com.epam.task1.repository.impl;

import com.epam.task1.entity.CustomArray;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {
    private static RepositoryImpl instance;
    private List<CustomArray> customArrays;

    private RepositoryImpl() {
        customArrays = new ArrayList<>();
    }

    public static RepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    public RepositoryImpl(List<CustomArray> customArrays) {
        this.customArrays = customArrays;
    }

    @Override
    public boolean add(CustomArray customArray) {
        return customArrays.add(customArray);
    }

    @Override
    public boolean addAll(Collection<CustomArray> collection) {
        return customArrays.addAll(collection);
    }

    @Override
    public boolean remove(CustomArray customArray) {
        return customArrays.remove(customArray);
    }

    @Override
    public boolean removeAll(Collection<CustomArray> collection) {
        return customArrays.removeAll(collection);
    }

    @Override
    public CustomArray get(int index) {
        return customArrays.get(index);
    }

    @Override
    public CustomArray set(int index, CustomArray customArray) {
        return customArrays.set(index, customArray);
    }

    @Override
    public List<CustomArray> getAll() {
        return customArrays;
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        List<CustomArray> list = customArrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        return customArrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
